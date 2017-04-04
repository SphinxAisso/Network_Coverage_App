import { Route } from '@angular/router';

import { ZsDocsComponent } from './docs.component';

export const docsRoute: Route = {
    path: 'docs',
    component: ZsDocsComponent,
    data: {
        pageTitle: 'global.menu.admin.apidocs'
    }
};
