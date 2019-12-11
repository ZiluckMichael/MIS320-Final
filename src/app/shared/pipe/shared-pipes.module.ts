import { NgModule } from "@angular/core";
import { ValidationErrorsPipe } from "./validation-errors.pipe";

@NgModule({
    declarations: [ValidationErrorsPipe],
    exports: [ValidationErrorsPipe]
})
export class SharedPipesModule {
}
