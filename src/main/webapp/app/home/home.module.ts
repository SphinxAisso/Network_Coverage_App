import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { CraSharedModule } from '../shared';

import { HOME_ROUTE, HomeComponent } from './';
import {AbsenceComponent} from "../absence/absence.component";
import {AbsenceService} from "../absence/absence.service";

@NgModule({
    imports: [
        CraSharedModule,
        RouterModule.forChild([ HOME_ROUTE ])
    ],
    declarations: [
        HomeComponent, AbsenceComponent
    ],
    entryComponents: [
    ],
    providers: [
        AbsenceService
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class CraHomeModule {}
