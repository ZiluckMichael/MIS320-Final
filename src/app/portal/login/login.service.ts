import { Injectable, OnDestroy } from "@angular/core";
import { AuthRequest } from "app/shared/model/auth-request.model";
import { LocalStorageHelperService } from "../../shared/service/local-storage-helper.service";
import { Key } from "../../shared/constants/key.constant";
import { UserHttpService } from "../../shared/service/http/user-http.service";
import { Subscription } from "rxjs";
import { Ng4LoadingSpinnerService } from "ng4-loading-spinner";
import { HttpErrorResponse } from "@angular/common/http";
import { ToastrService } from "ngx-toastr";
import { Router } from "@angular/router";
import { AuthGuard } from "../../shared/guard/auth.guard";
import { AuthResponse } from "../../shared/model/auth-response.model";
import { Path } from "../../shared/constants/path.constant";

@Injectable()
export class LoginService implements OnDestroy {
    private subscriptions: Subscription[] = [];

    constructor(
        private authGuard: AuthGuard<AuthRequest, AuthResponse>,
        private localStorageService: LocalStorageHelperService,
        private userHttpService: UserHttpService,
        private spinnerService: Ng4LoadingSpinnerService,
        private toastrService: ToastrService,
        private router: Router
    ) {
    }

    public login<U extends AuthRequest>(request: U, expectedTarget: string) {
        this.spinnerService.show();
        // TODO add user controller endpoints
        this.subscriptions.push(this.userHttpService.loginUser(request).subscribe(
            res => {
                this.localStorageService.setItem(Key.BEARER_TOKEN, res.token);
                this.subscriptions.push(this.userHttpService.getFullUser(request.username).subscribe(
                    res => {
                        this.localStorageService.setItem(Key.USER, res);
                        if (this.authGuard.permissionCheck(res)) {
                            this.router.navigate([this.getExpectedTarget(expectedTarget)]).catch((err) => this.handleError(err));
                        } else {
                            this.router.navigate([Path.ACCESS_DENIED]).catch((err) => this.handleError(err));
                        }
                    },
                    (err) => this.handleError(err),
                    () => {
                        this.spinnerService.hide();
                    }
                ));
            },
            (err) => this.handleError(err)
        ));
    }

    public getExpectedTarget(userProvided: string) {
        return userProvided ? userProvided : Path.DASHBOARD;
    }

    public clearLoginStorage() {
        this.localStorageService.removeItem(Key.USER);
        this.localStorageService.removeItem(Key.BEARER_TOKEN);
    }

    private handleError(res: HttpErrorResponse): void {
        let errorMessage = res.error.error_description || res.error.errorMessage || "Unknown problem during login.";
        this.toastrService.error(errorMessage, "LOGIN ERROR");
        this.spinnerService.hide();
    }

    ngOnDestroy(): void {
        this.subscriptions.forEach(value => value.unsubscribe());
        this.subscriptions = null;
    }
}
