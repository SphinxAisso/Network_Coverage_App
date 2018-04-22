import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';

import {CraSharedModule} from '../../shared';
import {
    EmployeeComponent,
    EmployeeDeleteDialogComponent,
    EmployeeDeletePopupComponent,
    EmployeeDetailComponent,
    EmployeeDialogComponent,
    EmployeePopupComponent,
    EmployeePopupService,
    EmployeeResolvePagingParams,
    EmployeeService,
} from './';

const ENTITY_STATES = [
    //  ...employeeRoute,
    //  ...employeePopupRoute,
];

@NgModule({
    imports: [
        CraSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        EmployeeComponent,
        EmployeeDetailComponent,
        EmployeeDialogComponent,
        EmployeeDeleteDialogComponent,
        EmployeePopupComponent,
        EmployeeDeletePopupComponent,
    ],
    entryComponents: [
        EmployeeComponent,
        EmployeeDialogComponent,
        EmployeePopupComponent,
        EmployeeDeleteDialogComponent,
        EmployeeDeletePopupComponent,
    ],
    providers: [
        EmployeeService,
        EmployeePopupService,
        EmployeeResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class CraEmployeeModule {
}
