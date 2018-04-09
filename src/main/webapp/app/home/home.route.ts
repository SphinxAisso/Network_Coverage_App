import { Route } from '@angular/router';

import { HomeComponent } from './';
import {UserRouteAccessService} from '../shared';

export const HOME_ROUTE: Route = {
    path: '',
    component: HomeComponent,
    data: {
        authorities: ['ROLE_USER', 'ROLE_ADMIN'],
        pageTitle: 'home.title'
    },
    canActivate: [UserRouteAccessService],
};
