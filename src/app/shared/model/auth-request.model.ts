import { IllegalArgumentError } from 'src/app/shared/error/illegal-argument.error';
import { xnor } from 'src/app/shared/utils/logical.util';

export class AuthRequestModel {
    constructor(public username?: string,
                public password?: string) {
        if (xnor(username, password)) {
            throw new IllegalArgumentError("Must specify either both or neither username and password.");
        }
    }
}
