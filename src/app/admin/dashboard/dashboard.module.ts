import { NgModule } from "@angular/core";
import { DashboardComponent } from "./dashboard.component";
import { DashboardRoutingModule } from "./dashboard-routing.module";
import { SortableModule } from "ngx-bootstrap";
import { FormsModule } from "@angular/forms";
import { CommonModule } from "@angular/common";

@NgModule({
    imports: [
        DashboardRoutingModule,
        SortableModule,
        FormsModule,
        CommonModule
    ],
    declarations: [
        DashboardComponent
    ]
})
export class DashboardModule {
}
