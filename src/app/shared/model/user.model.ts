import { Role } from "./role.model";

export class User {
    id: number;
    email: string;
    firstName: string;
    lastName: string;
    active: boolean;
    roleList: Role[];

    get fullName() {
        return this.firstName + ' ' + this.lastName;
    }
}
