import { Route } from '@angular/router';

import { DisplayAbsenceComponent } from './displayAbsence.component';

export const ABSENCES_ROUTE: Route = {
    path: 'displayAbsences',
    component: DisplayAbsenceComponent,
    data: {
        authorities: [],
        pageTitle: 'absences'
    }
};
