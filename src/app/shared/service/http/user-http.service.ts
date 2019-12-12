import { HttpClient, HttpParams } from "@angular/common/http";
import { AuthRequest } from "../../model/auth-request.model";
import { AuthResponse } from "../../model/auth-response.model";
import { Observable } from "rxjs";
import { HttpConstant } from "../../constants/http.constant";
import { User } from "../../model/user.model";
import { Key } from "../../constants/key.constant";
import { Injectable } from "@angular/core";

@Injectable()
export class UserHttpService {
    constructor(private client: HttpClient) {
    }

    loginUser<U extends AuthRequest, T extends AuthResponse>(authRequest: U): Observable<AuthResponse> {
        return this.client.post<AuthResponse>(
            HttpConstant.POST_AUTHENTICATE,
            authRequest
        );
    }

    registerUser<U extends User, T extends AuthResponse>(user: U): Observable<AuthResponse> {
        return this.client.post<AuthResponse>(
            HttpConstant.POST_REGISTER,
            user
        );
    }

    getFullUser(username: string): Observable<User> {
        let httpParams = new HttpParams()
            .set(Key.USERNAME, username);

        return this.client.get<User>(
            HttpConstant.GET_USER,
            { params: httpParams }
        );
    }
}
