import {Component, OnInit} from "@angular/core";
import {DisplayAbsenceService} from "./displayAbsence.service";

@Component({
    selector : 'displayAbsence',
    templateUrl : './displayAbsence.component.html',
    styleUrls : ['./displayAbsence.scss']
})


export class DisplayAbsenceComponent implements OnInit {

    absences : { startDate: Date, endDate: Date, absenceType: String }


    constructor(private displayabsenceService : DisplayAbsenceService){

    }

    ngOnInit() {
        this.getAbsence();
    }

    getAbsence(){
        this.displayabsenceService.getAbsence().subscribe((absence) => {
            console.log('absence get success');
            this.absences.startDate = absence.startDate;
            this.absences.endDate = absence.endDate;
            this.absences.absenceType = absence.absenceType;
        }, (response) => console.log('absence get failed', response));

    }

}
