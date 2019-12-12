import { Injectable } from "@angular/core";
import { HttpClient, HttpParams } from "@angular/common/http";
import { Observable } from "rxjs";
import { Guest } from "../../model/guest.model";

@Injectable()
export class GuestHttpService {
    constructor(private client: HttpClient) {
    }

    getGuestById(personId: number): Observable<Guest> {
        let httpParams = new HttpParams()
            .set("personId", String(personId));

        return this.client.get<Guest>(
            "/guest",
            { params: httpParams }
        );
    }
}
