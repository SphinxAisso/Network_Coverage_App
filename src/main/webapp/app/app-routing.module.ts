import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {errorRoute, NavbarComponent} from './layouts';
import {FullLayoutComponent} from './layouts/full-layout/full-layout.component';
import {SimpleLayoutComponent} from './layouts/simple-layout/simple-layout.component';
import {HOME_ROUTE} from './home';
import {LOGIN_ROUTE} from './zs-login';
import {adminState, userDialogRoute} from './admin';
import {accountState} from './account';
import {employeePopupRoute, employeeRoute} from './entities/employee';

export const LAYOUT_ROUTES: Routes = [
    {
        path: '',
        component: FullLayoutComponent,
        children: [
            HOME_ROUTE,
            ...adminState,
            ...accountState,
            {
                path: '',
                component: NavbarComponent,
                outlet: 'navbar'
            },
            ...employeeRoute,
        ],

    },
    {
        path: '',
        component: SimpleLayoutComponent,
        children: [
            LOGIN_ROUTE,
            ...errorRoute
        ],
    },
    ...userDialogRoute,
    ...employeePopupRoute
];

@NgModule({
    imports: [
        RouterModule.forRoot(LAYOUT_ROUTES, {useHash: true})
    ],
    exports: [
        RouterModule
    ]
})
export class CraAppRoutingModule {
}
