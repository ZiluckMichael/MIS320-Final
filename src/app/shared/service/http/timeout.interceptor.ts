import { Injectable } from "@angular/core";
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Observable } from "rxjs";
import { timeout } from "rxjs/operators";

@Injectable()
export class TimeoutInterceptor implements HttpInterceptor {
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const timeoutValue = req.headers.get('timeout') || 120000;
        const parsedTimeout = Number(timeoutValue);

        return next.handle(req).pipe(timeout(parsedTimeout));
    }
}
