import { LoginService } from './../shared/login/login.service';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { CraSharedModule } from '../shared';

import { LOGIN_ROUTE, ZsLoginComponent } from './';
import { StateStorageService } from '../shared/auth/state-storage.service';

@NgModule({
    imports: [
        CraSharedModule,
        RouterModule.forChild([ LOGIN_ROUTE ]),
    ],
    declarations: [
        ZsLoginComponent
    ],
    providers: [
        LoginService,
        StateStorageService
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ZsLoginModule {}
