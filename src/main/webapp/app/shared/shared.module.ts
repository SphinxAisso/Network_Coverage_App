import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { DatePipe } from '@angular/common';

import {
    CraSharedLibsModule,
    CraSharedCommonModule,
    CSRFService,
    AuthServerProvider,
    AccountService,
    UserService,
    StateStorageService,
    LoginService,
    Principal,
    ZsTrackerService,
    HasAnyAuthorityDirective,
    ZsSocialComponent,
    SocialService,
} from './';

@NgModule({
    imports: [
        CraSharedLibsModule,
        CraSharedCommonModule
    ],
    declarations: [
        ZsSocialComponent,
        HasAnyAuthorityDirective
    ],
    providers: [
        LoginService,
        AccountService,
        StateStorageService,
        Principal,
        CSRFService,
        ZsTrackerService,
        AuthServerProvider,
        SocialService,
        UserService,
        DatePipe
    ],
    exports: [
        CraSharedCommonModule,
        ZsSocialComponent,
        HasAnyAuthorityDirective,
        DatePipe
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]

})
export class CraSharedModule {}
