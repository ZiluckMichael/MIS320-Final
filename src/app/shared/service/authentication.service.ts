import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthResponseModel } from 'src/app/shared/model/auth-response.model';
import { AuthRequestModel } from 'src/app/shared/model/auth-request.model';
import { shareReplay } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class AuthenticationService {
    constructor(private httpClient: HttpClient) {
    }

    authenticate(username: string, password: string): Observable<AuthResponseModel> {
        const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });

        const requestModel: AuthRequestModel = new AuthRequestModel(username, password);

        return this.httpClient.post<AuthResponseModel>("/noauth/authenticate", requestModel).pipe(shareReplay());
    }
}
