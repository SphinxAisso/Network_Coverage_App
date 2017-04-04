import { Route } from '@angular/router';

import { ZsTrackerComponent } from './tracker.component';

export const trackerRoute: Route = {
    path: 'zs-tracker',
    component: ZsTrackerComponent,
    data: {
        pageTitle: 'tracker.title'
    }
};
