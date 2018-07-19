import {Component, OnInit} from "@angular/core";
import {DisplayAbsenceService} from "./displayAbsence.service";
import {Absence} from "./absence";



@Component({
    selector : 'displayAbsence',
    templateUrl : './displayAbsence.component.html',
    styleUrls : ['./displayAbsence.scss']
})


export class DisplayAbsenceComponent implements OnInit {


    absences : Array<absence>

    constructor(private displayAbsenceService : DisplayAbsenceService){

    }

    ngOnInit() {
         this.getAbsence();
    }

    getAbsence(){
        this.displayAbsenceService.getAbsence().subscribe((absencesJson) => {
            console.log('absence get success ', absencesJson);
            this.absences = absencesJson;

        }, (response) => console.log('absence get failed', response));

    }

}
