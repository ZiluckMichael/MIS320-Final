import { Component, OnInit } from '@angular/core';
import { Reservation } from "../../shared/model/reservation";
import { ReservationHttpService } from "../../shared/service/http/reservation-http.service";
import { Room } from "../../shared/model/room.model";
import { Ng4LoadingSpinnerService } from "ng4-loading-spinner";
import { ToastrService } from "ngx-toastr";
import { LocalStorageHelperService } from "../../shared/service/local-storage-helper.service";
import { Key } from "../../shared/constants/key.constant";
import { TitleService } from "../../shared/service/title.service";
import { Router } from "@angular/router";

@Component({
    selector: 'app-reservation',
    templateUrl: './reservation.component.html'
})
export class ReservationComponent implements OnInit {
    reservation: Reservation;

    rooms: Room[] = [];

    constructor(private reservationHttpService: ReservationHttpService,
                private spinnerService: Ng4LoadingSpinnerService,
                private toastrService: ToastrService,
                private localStorageHelperService: LocalStorageHelperService,
                private titleService: TitleService,
                private router: Router) {
        this.reservation = new Reservation();
        this.reservation.startDate = new Date(Date.now());
        this.reservation.guestId = localStorageHelperService.getItem(Key.USER).id;
        this.titleService.setTitle("Reservation");
    }

    ngOnInit() {
        this.reservationHttpService.getAllRooms().subscribe(res => {
            this.rooms = res;
        });
    }

    now(): string {
        return new Date(Date.now()).toISOString();
    }

    reserve() {
        this.spinnerService.show();
        this.reservationHttpService.saveReservation(this.reservation).subscribe(res => {
            this.toastrService.success("Successfully made a new reservation");
            this.router.navigate(['/admin/dashboard']);
        }, error => {
            this.toastrService.error("Reservation broke :(");
            this.spinnerService.hide();
        }, () => {
            this.spinnerService.hide();
        });
        console.log('reserved');
    }
}
