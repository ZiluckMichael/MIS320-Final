export abstract class Person {
    personId: number;
    firstName: string;
    lastName: string;
    birthDate: Date;
    phone: string;
    phoneExt: string;

    public constructor(init?: Partial<Person>) {
        Object.assign(this, init);
    }

    getFullName(): string {
        return `${this.firstName} ${this.lastName}`;
    }

    get fullName(): string {
        return `${this.firstName} ${this.lastName}`;
    }
}
