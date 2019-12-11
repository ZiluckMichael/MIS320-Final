import { BrowserModule } from '@angular/platform-browser';
import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';

import { AppRoutingModule } from 'app/app-routing.module';
import { AppComponent } from 'app/app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { SlimLoadingBarModule, SlimLoadingBarService } from "ng2-al-slim-bar";
import { Ng4LoadingSpinnerModule } from "ng4-loading-spinner";
import { ToastrModule, ToastrService } from "ngx-toastr";
import { AuthGuard } from "app/shared/guard/auth.guard";
import { GuardHandlerService } from "app/shared/guard/guard-handler.service";
import { LocalStorageHelperService } from "app/shared/service/local-storage-helper.service";
import { SessionStorageHelperService } from "app/shared/service/session-storage-helper.service";
import { TitleService } from "./shared/service/title.service";
import { UserHttpService } from "./shared/service/http/user-http.service";
import { ValidationErrorsPipe } from "./shared/pipe/validation-errors.pipe";
import { SharedPipesModule } from "./shared/pipe/shared-pipes.module";
import { TimeoutInterceptor } from "./shared/service/http/timeout.interceptor";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";


@NgModule({
    declarations: [
        AppComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        NgbModule,
        HttpClientModule,
        SlimLoadingBarModule.forRoot(),
        Ng4LoadingSpinnerModule.forRoot(),
        BrowserAnimationsModule,
        ToastrModule.forRoot({
            closeButton: true,
            timeOut: 5000,
            extendedTimeOut: 2000,
            progressBar: true
        })
    ],
    schemas: [NO_ERRORS_SCHEMA],
    providers: [
        AuthGuard,
        GuardHandlerService,
        ToastrService,
        TitleService,
        UserHttpService,
        SlimLoadingBarService,
        LocalStorageHelperService,
        SessionStorageHelperService,
        [{ provide: HTTP_INTERCEPTORS, useClass: TimeoutInterceptor, multi: true }]
    ],
    exports: [],
    bootstrap: [AppComponent]
})
export class AppModule {
}
