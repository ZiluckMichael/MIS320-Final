import { AuthRequest } from 'app/shared/model/auth-request.model';
import { AuthResponse } from 'app/shared/model/auth-response.model';
import { Injectable } from '@angular/core';
import {
    ActivatedRouteSnapshot,
    CanActivate,
    GuardsCheckEnd,
    NavigationCancel,
    NavigationEnd,
    NavigationError,
    ResolveEnd,
    Router,
    RouterStateSnapshot,
    UrlTree
} from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LocalStorageHelperService } from 'app/shared/service/local-storage-helper.service';
import { Key } from 'app/shared/constants/key.constant';
import { GuardHandlerService } from 'app/shared/guard/guard-handler.service';
import { User } from "../model/user.model";

@Injectable()
export class AuthGuard<U extends AuthRequest, R extends AuthResponse> implements CanActivate {
    private inProgress: boolean;

    constructor(private router: Router,
                private httpClient: HttpClient,
                private guardHandler: GuardHandlerService,
                private localStorageHelper: LocalStorageHelperService) {
        this.router.events.subscribe(event => {
            this.inProgress = !(event instanceof NavigationEnd ||
                event instanceof NavigationCancel ||
                event instanceof NavigationError ||
                event instanceof GuardsCheckEnd ||
                event instanceof ResolveEnd);
        });
    }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
        if (this.localStorageHelper.getItem(Key.BEARER_TOKEN)) {
            return true;
        }
        this.guardHandler.forceLoginRedirect(state.url);
        return false;
    }

    public permissionCheck<T extends User>(user: T): boolean {
        return !(!user.roleList || user.roleList.length === 0);
    }
}
