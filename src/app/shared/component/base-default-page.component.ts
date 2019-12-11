import { OnInit } from "@angular/core";
import { Path } from "../constants/path.constant";
import { TitleService } from "../service/title.service";

export abstract class BaseDefaultPageComponent implements OnInit {
    loginPath: string;

    protected constructor(titleService: TitleService) {
        titleService.setTitle(this.getPageName());
    }

    ngOnInit() {
        this.loginPath = Path.LOGIN
    }

    abstract getPageName(): string;
}
