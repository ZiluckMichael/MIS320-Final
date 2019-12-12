import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReservationComponent } from './reservation.component';
import { ReservationRoutingModule } from "./reservation-routing.module";
import { FormsModule } from "@angular/forms";
import { SharedPipesModule } from "../../shared/pipe/shared-pipes.module";


@NgModule({
    declarations: [ReservationComponent],
    imports: [
        CommonModule,
        ReservationRoutingModule,
        FormsModule,
        SharedPipesModule
    ]
})
export class ReservationModule {
}
