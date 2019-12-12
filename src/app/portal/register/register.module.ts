import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { FormsModule } from "@angular/forms";
import { CommonModule } from "@angular/common";
import { SharedPipesModule } from "../../shared/pipe/shared-pipes.module";
import { RegisterComponent } from "./register.component";
import { RegisterRoutingModule } from "./register-routing.module";

@NgModule({
    imports: [
        RouterModule,
        RegisterRoutingModule,
        FormsModule,
        CommonModule,
        SharedPipesModule
    ],
    declarations: [
        RegisterComponent
    ]
})
export class RegisterModule {
}
