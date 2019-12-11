import { IllegalArgumentError } from 'app/shared/error/illegal-argument.error';

export class AuthRequest {
    constructor(public username?: string,
                public password?: string) {
        if ((this.username == null && this.password != null) ||
            (this.username != null && this.password == null)) {
            throw new IllegalArgumentError("Must specify either both or neither username and password.");
        }
    }
}
