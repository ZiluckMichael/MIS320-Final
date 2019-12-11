import { Component } from '@angular/core';
import { BaseDefaultPageComponent } from "../shared/component/base-default-page.component";
import { TitleService } from "../shared/service/title.service";

@Component({
    selector: 'app-access-denied',
    templateUrl: './access-denied.component.html'
})
export class AccessDeniedComponent extends BaseDefaultPageComponent {
    constructor(private titleService: TitleService) {
        super(titleService);
    }

    getPageName(): string {
        return "Access Denied";
    }
}
