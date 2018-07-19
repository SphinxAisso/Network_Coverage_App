import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import {AbsenceService} from "../absence/absence.service";
import {ABSENCES_ROUTE} from "./displayAbsence.route";
import {DisplayAbsenceComponent} from "./displayAbsence.component";
import {CraSharedModule} from "../shared";

@NgModule({
    imports: [
        CraSharedModule,
        RouterModule.forChild([ ABSENCES_ROUTE ])
    ],
    declarations: [
        DisplayAbsenceComponent,
    ],
    exports: [
        DisplayAbsenceComponent
    ],
    providers: [
        AbsenceService
    ],
    schemas: []
})
export class DisplayAbsenceModule {}
