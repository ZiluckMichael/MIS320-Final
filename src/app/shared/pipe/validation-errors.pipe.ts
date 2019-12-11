import { Pipe, PipeTransform } from "@angular/core";
import { NgModel } from "@angular/forms";

@Pipe({ name: 'validationErrors' })
export class ValidationErrorsPipe implements PipeTransform {
    transform(model: NgModel, fieldName: string): any {
        if (model.errors) {
            fieldName = fieldName.charAt(0).toUpperCase() + fieldName.slice(1);
            let errors = model.errors;
            if (errors['required']) {
                return fieldName + " is required.";
            } else if (errors['email']) {
                return "Invalid email format.";
            } else if (errors['minlength']) {
                return fieldName + " is too short. Minimum length: " + errors['minlength']['requiredLength'];
            }
        }
    }
}
