import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { ReservationComponent } from "./reservation.component";

const routes: Routes = [
    { path: '', component: ReservationComponent, children: [] }
];

@NgModule({
    imports: [
        RouterModule.forChild(routes)
    ],
    exports: [
        RouterModule
    ]
})
export class ReservationRoutingModule {
}
