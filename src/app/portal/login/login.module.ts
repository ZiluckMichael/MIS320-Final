import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { LoginRoutingModule } from "./login-routing.module";
import { FormsModule } from "@angular/forms";
import { LoginComponent } from "./login.component";
import { CommonModule } from "@angular/common";
import { LoginService } from "./login.service";
import { SharedPipesModule } from "../../shared/pipe/shared-pipes.module";

@NgModule({
    imports: [
        RouterModule,
        LoginRoutingModule,
        FormsModule,
        CommonModule,
        SharedPipesModule
    ],
    declarations: [
        LoginComponent
    ],
    providers: [
        LoginService
    ]
})
export class LoginModule {
}
