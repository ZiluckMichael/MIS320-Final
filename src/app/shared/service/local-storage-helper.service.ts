import { Injectable } from '@angular/core';
import { StorageHelperService } from 'app/shared/service/base-storage-helper.service';

@Injectable()
export class LocalStorageHelperService extends StorageHelperService {
    constructor() {
        super();
        this.storageRef = localStorage;
    }
}
