import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, ActivatedRouteSnapshot, NavigationEnd, Router} from '@angular/router';
import {JhiLanguageHelper, Principal} from '../../shared';

@Component({
    selector: 'zs-error',
    templateUrl: './error.component.html'
})
export class ErrorComponent implements OnInit {
    errorMessage: string;
    errorHttpCode: string;

    constructor(
        private route: ActivatedRoute
    ) {}

    ngOnInit() {
        this.route.data.subscribe((routeData) => {
            if (routeData.errorHttpCode) {
                this.errorHttpCode = routeData.errorHttpCode;
            }
            if (routeData.errorMessage) {
                this.errorMessage = routeData.errorMessage;
            }
        });
    }
}
