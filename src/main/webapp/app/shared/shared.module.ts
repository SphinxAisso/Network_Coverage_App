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
    LoginModalService,
    ZsLoginModalComponent,
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
        ZsLoginModalComponent,
        HasAnyAuthorityDirective
    ],
    providers: [
        LoginService,
        LoginModalService,
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
    entryComponents: [ZsLoginModalComponent],
    exports: [
        CraSharedCommonModule,
        ZsSocialComponent,
        ZsLoginModalComponent,
        HasAnyAuthorityDirective,
        DatePipe
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]

})
export class CraSharedModule {}
