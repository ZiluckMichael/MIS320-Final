import { Component } from '@angular/core';
import { BaseDefaultPageComponent } from "../shared/component/base-default-page.component";
import { TitleService } from "../shared/service/title.service";

@Component({
    selector: 'not-found',
    templateUrl: './not-found.component.html'
})
export class NotFoundComponent extends BaseDefaultPageComponent {
    constructor(private titleService: TitleService) {
        super(titleService);
    }

    getPageName(): string {
        return "Not Found";
    }
}
