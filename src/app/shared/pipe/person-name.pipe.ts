import { Pipe, PipeTransform } from "@angular/core";
import { GuestHttpService } from "../service/http/guest-http.service";

@Pipe({
    name: 'guestName'
})
export class GuestNamePipe implements PipeTransform {
    constructor(guestHttpService: GuestHttpService) {
    }

    transform(value: number): string {

    }

}
