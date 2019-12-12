import { RouterModule, Routes } from "@angular/router";
import { NgModule } from "@angular/core";
import { AdminComponent } from "./admin.component";

const routes: Routes = [
    {
        path: '', component: AdminComponent,
        children: [
            {
                path: 'dashboard',
                loadChildren: () => import('./dashboard/dashboard.module').then(m => m.DashboardModule)
            }
        ]
    }
];


@NgModule({
    imports: [
        RouterModule.forChild(routes)
    ],
    exports: [
        RouterModule
    ]
})
export class AdminRoutingModule {
}
