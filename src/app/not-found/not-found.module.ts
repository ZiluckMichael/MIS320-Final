import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { NotFoundComponent } from "app/not-found/not-found.component";
import { NotFoundRoutingModule } from "app/not-found/not-found-routing.module";

@NgModule({
    imports: [
        RouterModule,
        NotFoundRoutingModule
    ],
    declarations: [NotFoundComponent]
})
export class NotFoundModule {
}
