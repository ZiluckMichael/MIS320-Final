import { Component, OnInit, ViewEncapsulation } from "@angular/core";
import { Router } from "@angular/router";
import { ToastrService } from "ngx-toastr";

@Component({
    selector: 'app-admin',
    templateUrl: './admin.component.html',
    encapsulation: ViewEncapsulation.None
})
export class AdminComponent implements OnInit {
    constructor(private router: Router,
                private toastr: ToastrService) {
    }

    ngOnInit(): void {
        if (this.router.url === '/admin') {
            this.router.navigate(['/admin/dashboard']).then(() => this.toastr.error("Unexpected error when navigating to dashboard."));
        }
    }
}
