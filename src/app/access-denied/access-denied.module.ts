import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { AccessDeniedRoutingModule } from "app/access-denied/access-denied-routing.module";
import { AccessDeniedComponent } from "app/access-denied/access-denied.component";

@NgModule({
    imports: [
        RouterModule,
        AccessDeniedRoutingModule
    ],
    declarations: [AccessDeniedComponent]
})
export class AccessDeniedModule {
}
