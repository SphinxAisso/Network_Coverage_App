import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {CraSharedModule, LoginService, StateStorageService} from '../shared';
import {ZsLoginComponent} from './';

@NgModule({
    imports: [
        CraSharedModule
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
export class ZsLoginModule {
}
