import { Route } from '@angular/router';

import { ZsHealthCheckComponent } from './health.component';

export const healthRoute: Route = {
    path: 'zs-health',
    component: ZsHealthCheckComponent,
    data: {
        pageTitle: 'health.title'
    }
};
