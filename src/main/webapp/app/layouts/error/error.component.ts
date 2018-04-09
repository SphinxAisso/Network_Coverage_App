import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, ActivatedRouteSnapshot, NavigationEnd, Router} from '@angular/router';
import {JhiLanguageHelper, Principal} from "../../shared";

@Component({
    selector: 'zs-error',
    templateUrl: './error.component.html'
})
export class ErrorComponent implements OnInit {
    errorMessage: string;
    errorHttpCode: boolean;

    constructor(
        private route: ActivatedRoute,
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
