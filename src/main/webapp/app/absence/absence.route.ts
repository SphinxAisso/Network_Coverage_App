import { Route } from '@angular/router';

import { AbsenceComponent } from './absence.component';

export const ADD_ABSENCE_ROUTE: Route = {
    path: 'addAbsence',
    component: AbsenceComponent,
    data: {
        authorities: [],
        pageTitle: 'addAbsence'
    }
};
