import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRouteSnapshot, NavigationEnd} from '@angular/router';
import {JhiLanguageHelper, Principal} from '../../shared';

@Component({
    selector: 'body',
    template: '<router-outlet></router-outlet><router-outlet name="popup"></router-outlet>'
})
export class ZsMainComponent implements OnInit {

    constructor(private principal: Principal,
                private jhiLanguageHelper: JhiLanguageHelper,
                private router: Router) {
    }

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
                return;
            }
            window.scrollTo(0, 0);
        });
    }

    isAuthenticated() {
        return this.principal.isAuthenticated();
    }
}
