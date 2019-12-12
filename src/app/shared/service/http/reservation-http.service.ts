import { Injectable } from "@angular/core";
import { HttpClient, HttpParams } from "@angular/common/http";
import { Observable } from "rxjs";
import { Reservation } from "../../model/reservation";
import { Room } from "../../model/room.model";

@Injectable()
export class ReservationHttpService {
    constructor(private client: HttpClient) {
    }

    getReservation(reservationId: number): Observable<Reservation> {
        let httpParams = new HttpParams()
            .set("reservationId", String(reservationId));

        return this.client.get<Reservation>(
            "/reservation",
            { params: httpParams }
        );
    }

    getAllReservations(): Observable<Reservation[]> {
        return this.client.get<Reservation[]>("/reservation/all")
    }

    saveReservation(reservation: Reservation): Observable<Reservation> {
        return this.client.post<Reservation>("/reservation", reservation);
    }

    getAllRooms(): Observable<Room[]> {
        return this.client.get<Room[]>("/reservation/rooms");
    }
}
