import { ChangeDetectorRef, Component, OnInit, ViewEncapsulation } from "@angular/core";
import { Reservation } from "../../shared/model/reservation";
import { ReservationHttpService } from "../../shared/service/http/reservation-http.service";
import { GuestHttpService } from "../../shared/service/http/guest-http.service";
import { Guest } from "../../shared/model/guest.model";
import { Observable } from "rxjs";

@Component({
    selector: 'app-dashboard',
    templateUrl: './dashboard.component.html',
    encapsulation: ViewEncapsulation.None
})
export class DashboardComponent implements OnInit {
    reservations: Reservation[];
    reservationGuestLookups: { [guestId: number]: Observable<Guest> } = {};
    guestCache: { [guestId: number]: Guest } = {};

    constructor(private reservationHttpService: ReservationHttpService,
                private guestHttpService: GuestHttpService,
                private changeDetector: ChangeDetectorRef) {

    }

    ngOnInit(): void {
        // todo add error handling and unsubsribe
        this.reservationHttpService.getAllReservations().subscribe(res => {
            this.reservations = res;
            this.reservations.forEach(value => {
                this.reservationGuestLookups[value.guestId] = this.guestHttpService.getGuestById(value.guestId);
                this.reservationGuestLookups[value.guestId].subscribe(res => {
                    this.guestCache[value.guestId] = res;
                    this.changeDetector.detectChanges();
                });
            });
        });
    }

    wrapGuest(init?: Partial<Guest>): Guest {
        return new Guest(init);
    }
}
