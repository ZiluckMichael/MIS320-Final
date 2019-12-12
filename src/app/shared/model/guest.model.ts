import { Person } from "./person.model";

export class Guest extends Person {
    rewardsNumber: string;
    rewardsPoints: number;

    public constructor(init?: Partial<Guest>) {
        super(init);
        Object.assign(this, init);
    }

    getFullName(): string {
        return `${this.firstName} ${this.lastName}`;
    }

    get fullName(): string {
        return `${this.firstName} ${this.lastName}`;
    }
}
