import { NgModule } from "@angular/core";
import { HeaderComponent } from "./header/header.component";
import { CommonModule } from "@angular/common";
import { RouterModule } from "@angular/router";
import { FooterComponent } from "./footer/footer.component";
import { AdminComponent } from "./admin.component";
import { AdminRoutingModule } from "./admin-routing.module";
import { CollapseModule } from "ngx-bootstrap";

@NgModule({
    imports: [
        AdminRoutingModule,
        CommonModule,
        RouterModule,
        CollapseModule
    ],
    declarations: [
        AdminComponent,
        HeaderComponent,
        FooterComponent
    ]
})
export class AdminModule {

}
