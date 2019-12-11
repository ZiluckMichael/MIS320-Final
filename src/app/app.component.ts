import { Component, OnDestroy } from '@angular/core';
import { SlimLoadingBarService } from "ng2-al-slim-bar";
import { NavigationCancel, NavigationEnd, NavigationError, NavigationStart, Router } from "@angular/router";
import { Subscription } from "rxjs";

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnDestroy {
    private subscription: Subscription;

    private template = `<div class="page-spinner"></div>`;

    constructor(
        private router: Router,
        private slimLoadingBar: SlimLoadingBarService
    ) {
        this.subscription = this.router.events.subscribe(event => {
            if (event instanceof NavigationStart) {
                this.slimLoadingBar.start();
            } else if (
                event instanceof NavigationEnd ||
                event instanceof NavigationCancel ||
                event instanceof NavigationError
            ) {
                this.slimLoadingBar.complete();
            }
        }, (error: any) => {
            this.slimLoadingBar.complete();
        })
    }

    ngOnDestroy(): void {
        this.subscription.unsubscribe();
    }
}
