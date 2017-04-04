import { NgModule, LOCALE_ID } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { registerLocaleData } from '@angular/common';
import locale from '@angular/common/locales/fr';

import { WindowRef } from './tracker/window.service';
import {
    CraSharedLibsModule,
    JhiLanguageHelper,
    FindLanguageFromKeyPipe,
    ZsAlertComponent,
    ZsAlertErrorComponent
} from './';

@NgModule({
    imports: [
        CraSharedLibsModule
    ],
    declarations: [
        FindLanguageFromKeyPipe,
        ZsAlertComponent,
        ZsAlertErrorComponent
    ],
    providers: [
        JhiLanguageHelper,
        WindowRef,
        Title,
        {
            provide: LOCALE_ID,
            useValue: 'fr'
        },
    ],
    exports: [
        CraSharedLibsModule,
        FindLanguageFromKeyPipe,
        ZsAlertComponent,
        ZsAlertErrorComponent
    ]
})
export class CraSharedCommonModule {
    constructor() {
        registerLocaleData(locale);
    }
}
