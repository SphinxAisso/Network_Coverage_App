import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';
import {Absence} from "./absence.model";
import {AbsenceService} from "./absence.service";
import {AbsenceModalService} from "./absence-modal.service";

@Component({
    selector: 'zs-absence-mgmt-delete-dialog',
    templateUrl: './absence-management-delete-dialog.component.html'
})
export class AbsenceMgmtDeleteDialogComponent{

    absence: Absence;

    constructor(
        private absenceService: AbsenceService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id) {
        this.absenceService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({ name: 'absenceListModification',
                content: 'Deleted an absence'});
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'zs-absence-delete-dialog',
    template: ''
})
export class UserDeleteDialogComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private absenceModalService: AbsenceModalService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.absenceModalService.open(AbsenceMgmtDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
