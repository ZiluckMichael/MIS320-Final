import { Component, OnDestroy, OnInit } from "@angular/core";
import { Subscription } from "rxjs";
import { AuthGuard } from "../../shared/guard/auth.guard";
import { AuthRequest } from "../../shared/model/auth-request.model";
import { AuthResponse } from "../../shared/model/auth-response.model";
import { TitleService } from "../../shared/service/title.service";
import { ActivatedRoute, Router } from "@angular/router";
import { AuthenticationService } from "../authentication.service";
import { RegisterUser } from "./register-user.model";

@Component({
    selector: 'app-register',
    templateUrl: './register.component.html',
})
export class RegisterComponent implements OnInit, OnDestroy {
    user: RegisterUser;

    private subscriptions: Subscription[] = [];

    constructor(
        private authGuard: AuthGuard<AuthRequest, AuthResponse>,
        private titleService: TitleService,
        private router: Router,
        private activatedRoute: ActivatedRoute,
        private authService: AuthenticationService
    ) {
        this.titleService.setTitle('Register');
    }

    register() {
        this.authService.clearLoginStorage();
        this.user.email = this.user.email.toLowerCase();
        this.authService.register(this.user);
    }

    ngOnInit() {
        this.user = new RegisterUser();
    }

    ngOnDestroy(): void {
        this.subscriptions.forEach(value => value.unsubscribe());
        this.subscriptions = null;
        this.user = null;
    }
}
