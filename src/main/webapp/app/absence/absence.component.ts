import {Component, OnInit} from "@angular/core";
import {AbsenceService} from "./absence.service";

@Component({
    selector : 'absence',
    templateUrl : './absence.component.html',
    styleUrls : ['./absence.scss']

})


export class AbsenceComponent implements OnInit {

    startDate: Date
    endDate: Date
    typeAbsence: String
    absences: any



    constructor(private absenceService : AbsenceService){

    }

    ngOnInit() {
    }

    create(){
        this.absences = {startDate: this.startDate, endDate: this.endDate, typeAbsence: this.typeAbsence}
        this.absenceService.create(this.absences).subscribe(() => {
            console.log('absence create success');
        }, (response) => console.log('absence create failed', response));
    }
}
