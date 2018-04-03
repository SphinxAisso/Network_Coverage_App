import { Route } from '@angular/router';

import { ZsLoginComponent } from './';

export const LOGIN_ROUTE: Route = {
    path: 'login',
    component: ZsLoginComponent,
    data: {
        authorities: [],
        pageTitle: 'login.title'
    }
};
