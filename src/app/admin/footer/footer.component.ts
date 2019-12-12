import { Component } from "@angular/core";
import { Router } from "@angular/router";

@Component({
    selector: 'admin-footer',
    templateUrl: './footer.component.html'
})
export class FooterComponent {
    constructor(protected router: Router) {
    }
}
