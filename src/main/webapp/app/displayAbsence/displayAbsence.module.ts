import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import {AbsenceService} from "../absence/absence.service";
import {ABSENCES_ROUTE} from "./displayAbsence.route";
import {DisplayAbsenceComponent} from "./displayAbsence.component";

@NgModule({
    imports: [
        RouterModule.forChild([ ABSENCES_ROUTE ])
    ],
    declarations: [
        DisplayAbsenceComponent
    ],
    entryComponents: [
    ],
    providers: [
        AbsenceService
    ],
    schemas: []
})
export class DisplayAbsenceModule {}
