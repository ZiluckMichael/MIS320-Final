import { Component } from '@angular/core';
import { BaseDefaultPageComponent } from "../shared/component/base-default-page.component";
import { TitleService } from "../shared/service/title.service";
import { Router } from "@angular/router";
import { GuardHandlerService } from "../shared/guard/guard-handler.service";

@Component({
    selector: 'app-access-denied',
    templateUrl: './access-denied.component.html'
})
export class AccessDeniedComponent extends BaseDefaultPageComponent {
    constructor(private titleService: TitleService,
                router: Router,
                guardHandlerService: GuardHandlerService) {
        super(titleService, router, guardHandlerService);
    }

    getPageName(): string {
        return "Access Denied";
    }
}
