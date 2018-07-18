import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { CraSharedModule } from '../shared';

import { HOME_ROUTE, HomeComponent } from './';
import {AbsenceComponent} from "../absence/absence.component";
import {AbsenceService} from "../absence/absence.service";
import {DisplayAbsenceComponent} from "../displayAbsence/displayAbsence.component";
import {DisplayAbsenceService} from "../displayAbsence/displayAbsence.service";

@NgModule({
    imports: [
        CraSharedModule,
        RouterModule.forChild([ HOME_ROUTE ])
    ],
    declarations: [
        HomeComponent,/* AbsenceComponent,*/ DisplayAbsenceComponent
    ],
    entryComponents: [
    ],
    providers: [
        /*AbsenceService*/ DisplayAbsenceService
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class CraHomeModule {}
