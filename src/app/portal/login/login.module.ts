import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { FormsModule } from "@angular/forms";
import { CommonModule } from "@angular/common";
import { SharedPipesModule } from "../../shared/pipe/shared-pipes.module";
import { LoginComponent } from "./login.component";
import { LoginRoutingModule } from "./login-routing.module";

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
    ]
})
export class LoginModule {
}
