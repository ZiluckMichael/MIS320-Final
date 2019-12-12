import { Component } from '@angular/core';
import { BaseDefaultPageComponent } from "../shared/component/base-default-page.component";
import { TitleService } from "../shared/service/title.service";
import { GuardHandlerService } from "../shared/guard/guard-handler.service";
import { Router } from "@angular/router";

@Component({
    selector: 'not-found',
    templateUrl: './not-found.component.html'
})
export class NotFoundComponent extends BaseDefaultPageComponent {
    constructor(private titleService: TitleService,
                router: Router,
                guardHandlerService: GuardHandlerService) {
        super(titleService, router, guardHandlerService);
    }

    getPageName(): string {
        return "Not Found";
    }
}
