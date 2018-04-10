import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRouteSnapshot, NavigationEnd } from '@angular/router';

import {JhiLanguageHelper, Principal} from '../../shared';

@Component({
    selector: 'zs-main',
    templateUrl: './main.component.html'
})
export class ZsMainComponent implements OnInit {

    constructor(
        private principal: Principal,
        private jhiLanguageHelper: JhiLanguageHelper,
        private router: Router
    ) {}

    private getPageTitle(routeSnapshot: ActivatedRouteSnapshot) {
        let title: string = (routeSnapshot.data && routeSnapshot.data['pageTitle']) ? routeSnapshot.data['pageTitle'] : 'craApp';
        if (routeSnapshot.firstChild) {
            title = this.getPageTitle(routeSnapshot.firstChild) || title;
        }
        return title;
    }

    ngOnInit() {
        this.router.events.subscribe((event) => {
            if (event instanceof NavigationEnd) {
                this.jhiLanguageHelper.updateTitle(this.getPageTitle(this.router.routerState.snapshot.root));
            }
        });

        // Redirect to the login page if user is not logged in
        if (!this.isAuthenticated()) {
            this.router.navigate(['login']);
        } else {
            this.router.navigate(['']);
        }
    }

    isAuthenticated() {
        return this.principal.isAuthenticated();
    }
}
