import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { AccessDeniedComponent } from 'app/access-denied/access-denied.component';

const routes: Routes = [
    {
        path: '', component: AccessDeniedComponent,
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class AccessDeniedRoutingModule {
}
