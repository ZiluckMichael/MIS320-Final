import { Component } from "@angular/core";
import { Router } from "@angular/router";

@Component({
    selector: 'admin-header',
    templateUrl: './header.component.html'
})
export class HeaderComponent {
    isCollapsed: boolean;

    constructor(protected router: Router) {
    }
}
