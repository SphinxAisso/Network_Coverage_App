import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AbsenceComponent } from "../absence/absence.component";
import { AbsenceService } from "../absence/absence.service";
import { ADD_ABSENCE_ROUTE } from "./absence.route";

@NgModule({
    imports: [
        RouterModule.forChild([ ADD_ABSENCE_ROUTE ])
    ],
    declarations: [
        AbsenceComponent
    ],
    entryComponents: [
    ],
    providers: [
        AbsenceService
    ],
    schemas: []
})
export class AbsenceModule {}
