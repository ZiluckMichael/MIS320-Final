import { Injectable } from "@angular/core";
import { Title } from "@angular/platform-browser";

@Injectable()
export class TitleService {
    constructor(private titlePlatform: Title) {
    }

    setTitle(title: string) {
        this.titlePlatform.setTitle(`GMH | ${title}`);
    }
}
