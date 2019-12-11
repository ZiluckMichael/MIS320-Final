import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { Path } from 'app/shared/constants/path.constant';
import { AuthGuard } from 'app/shared/guard/auth.guard';
import { AccessDeniedComponent } from 'app/access-denied/access-denied.component';
import { NotFoundComponent } from 'app/not-found/not-found.component';

const routes: Routes = [
    { path: '', redirectTo: Path.LOGIN, pathMatch: 'full' },
    { path: 'portal', loadChildren: './portal/portal.module#PortalModule' },
    //{path: 'admin', loadChildren: './admin/admin.module#AdminModule', canActivate: [AuthGuard]},
    {
        path: '403',
        loadChildren: () => import('app/access-denied/access-denied.module').then(m => m.AccessDeniedModule)
    },
    { path: '**', redirectTo: '404' },
    {
        path: '404',
        loadChildren: () => import('app/not-found/not-found.module').then(m => m.NotFoundModule)
    },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
