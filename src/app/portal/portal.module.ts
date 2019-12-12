import { NgModule } from "@angular/core";
import { PortalRoutingModule } from "./portal-routing.module";
import { AuthenticationService } from "./authentication.service";
import { PortalComponent } from "./portal.component";

@NgModule({
    declarations: [
        PortalComponent
    ],
    imports: [
        PortalRoutingModule
    ],
    providers: [
        AuthenticationService
    ]
})
export class PortalModule {
}
