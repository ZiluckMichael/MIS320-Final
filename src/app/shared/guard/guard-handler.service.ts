import { Injectable } from '@angular/core';
import { HttpRequest } from '@angular/common/http';
import { Router } from '@angular/router';
import { LocalStorageHelperService } from 'app/shared/service/local-storage-helper.service';
import { SessionStorageHelperService } from 'app/shared/service/session-storage-helper.service';
import { Path } from 'app/shared/constants/path.constant';

@Injectable()
export class GuardHandlerService {
    requests: Array<HttpRequest<any>> = [];

    constructor(public router: Router,
                private localStorageService: LocalStorageHelperService,
                private sessionStorageService: SessionStorageHelperService) {
    }

    public forceLoginRedirect(prevUrl?: string) {
        this.sessionStorageService.clear();
        this.localStorageService.removeItem('user');
        if (prevUrl) {
            this.router.navigate([Path.LOGIN], { queryParams: { 'target': prevUrl } }).then(this.handleFail);
        } else {
            this.router.navigate([Path.LOGIN]).then(this.handleFail);
        }
    }

    handleFail: (value: boolean) => void = function (value: boolean) {
        if (!value) {
            throw new Error('Failed to redirect.');
        }
    }
}
