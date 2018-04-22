import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';

import {CraSharedModule} from '../shared';

import {
    ActivateComponent,
    ActivateService,
    PasswordComponent,
    PasswordResetFinishComponent,
    PasswordResetFinishService,
    PasswordResetInitComponent,
    PasswordResetInitService,
    PasswordService,
    PasswordStrengthBarComponent,
    Register,
    RegisterComponent,
    SessionsComponent,
    SessionsService,
    SettingsComponent,
    SocialRegisterComponent
} from './';

@NgModule({
    imports: [
        CraSharedModule,
        RouterModule
    ],
    declarations: [
        SocialRegisterComponent,
        ActivateComponent,
        RegisterComponent,
        PasswordComponent,
        PasswordStrengthBarComponent,
        PasswordResetInitComponent,
        PasswordResetFinishComponent,
        SessionsComponent,
        SettingsComponent
    ],
    providers: [
        SessionsService,
        Register,
        ActivateService,
        PasswordService,
        PasswordResetInitService,
        PasswordResetFinishService
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class CraAccountModule {
}
