import {Component, OnInit} from '@angular/core';
import {JhiEventManager} from 'ng-jhipster';
import {Account, Principal} from '../shared';
import {NavigationEnd, Router} from '@angular/router';

@Component({
    selector: 'zs-home',
    templateUrl: './home.component.html',
    styleUrls: [
        'home.scss'
    ]
})
export class HomeComponent implements OnInit {
    account: Account;

    constructor(private principal: Principal,
                private eventManager: JhiEventManager,
                private router: Router) {
    }

    ngOnInit() {
        this.principal.identity().then((account) => {
            this.account = account;
        });
        this.registerAuthenticationSuccess();
        this.router.events.subscribe((evt) => {
            if (!(evt instanceof NavigationEnd)) {
                return;
            }
            window.scrollTo(0, 0);
        });
    }

    registerAuthenticationSuccess() {
        this.eventManager.subscribe('authenticationSuccess', (message) => {
            this.principal.identity().then((account) => {
                this.account = account;
            });
        });
    }

    isAuthenticated() {
        return this.principal.isAuthenticated();
    }

}
