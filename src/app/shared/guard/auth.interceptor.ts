import { Injectable } from "@angular/core";
import { NavigationCancel, NavigationEnd, NavigationError, NavigationStart, Router } from "@angular/router";
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Observable, Subscription } from "rxjs";
import { LocalStorageHelperService } from "../service/local-storage-helper.service";
import { Key } from "../constants/key.constant";
import { GuardHandlerService } from "./guard-handler.service";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
    private inProgress: boolean;

    constructor(
        private router: Router,
        private localStorageService: LocalStorageHelperService,
        private guardHandlerService: GuardHandlerService
    ) {
        this.router.events.subscribe(routerEvent => {
            if (routerEvent instanceof NavigationEnd
                || routerEvent instanceof NavigationCancel
                || routerEvent instanceof NavigationError) {
                this.inProgress = false;
            } else if (routerEvent instanceof NavigationStart) {
                this.inProgress = true;
            }
        });
    }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        if (!req.url.startsWith("/noauth")) {
            let token = this.localStorageService.getItem(Key.BEARER_TOKEN);
            if (!token) {
                if (!this.inProgress) {
                    this.guardHandlerService.forceLoginRedirect(this.router.url);
                }
            } else {
                token = `Bearer ${token}`;
                req = req.clone({
                    setHeaders: {
                        Authorization: token
                    }
                });
            }
        }
        return next.handle(req);
    }
}
