import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from "./shared/guard/auth.guard";

const routes: Routes = [
    { path: '', redirectTo: 'admin', pathMatch: 'full' },
    {
        path: 'portal',
        loadChildren: () => import('./portal/portal.module').then(m => m.PortalModule)
    },
    {
        path: 'admin',
        loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule),
        canActivate: [AuthGuard]
    },
    {
        path: '403',
        loadChildren: () => import('./access-denied/access-denied.module').then(m => m.AccessDeniedModule)
    },
    { path: '**', redirectTo: '404' },
    {
        path: '404',
        loadChildren: () => import('./not-found/not-found.module').then(m => m.NotFoundModule)
    },
];

@NgModule({
    imports: [RouterModule.forRoot(routes, { enableTracing: true })],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
