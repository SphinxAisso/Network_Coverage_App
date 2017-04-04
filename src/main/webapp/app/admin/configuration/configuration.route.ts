import { Route } from '@angular/router';

import { ZsConfigurationComponent } from './configuration.component';

export const configurationRoute: Route = {
    path: 'zs-configuration',
    component: ZsConfigurationComponent,
    data: {
        pageTitle: 'configuration.title'
    }
};
