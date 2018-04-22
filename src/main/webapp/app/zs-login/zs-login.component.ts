import {Router} from '@angular/router';
import {Component, ElementRef, OnInit, Renderer} from '@angular/core';
import {JhiEventManager} from 'ng-jhipster';
import {LoginService, StateStorageService} from '../shared';

@Component({
    selector: 'zs-login',
    templateUrl: './zs-login.component.html'
})
export class ZsLoginComponent implements OnInit {

    authenticationError: boolean;
    username: string;
    password: string;
    rememberMe: boolean;
    credentials: any;

    constructor(private eventManager: JhiEventManager,
                private stateStorageService: StateStorageService,
                private renderer: Renderer,
                private elementRef: ElementRef,
                private loginService: LoginService,
                private router: Router) {
        this.credentials = {};
    }

    ngOnInit() {
        this.renderer.invokeElementMethod(this.elementRef.nativeElement.querySelector('#username'), 'focus', []);
    }

    login() {
        this.loginService.login({
            username: this.username,
            password: this.password,
            rememberMe: this.rememberMe
        }).then(() => {
            this.authenticationError = false;
            if (this.router.url === '/register' || (/^\/activate\//.test(this.router.url)) ||
                (/^\/reset\//.test(this.router.url))) {
                this.router.navigate(['']);
            }

            this.eventManager.broadcast({
                name: 'authenticationSuccess',
                content: 'Sending Authentication Success'
            });

            this.stateStorageService.storeUrl('/');

            // previousState was set in the authExpiredInterceptor before being redirected to login modal.
            // since login is succesful, go to stored previousState and clear previousState
            const redirect = this.stateStorageService.getUrl();
            if (redirect) {
                this.stateStorageService.storeUrl(null);
                this.router.navigate([redirect]);
            }

        }).catch(() => {
            this.authenticationError = true;
        });
    }

    requestResetPassword() {
        console.log('Passwed resset');
    }

    register() {
        console.log('Register');
    }
}
