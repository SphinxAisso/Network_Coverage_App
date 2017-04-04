import { Route } from '@angular/router';

import { ZsMetricsMonitoringComponent } from './metrics.component';

export const metricsRoute: Route = {
    path: 'zs-metrics',
    component: ZsMetricsMonitoringComponent,
    data: {
        pageTitle: 'metrics.title'
    }
};
