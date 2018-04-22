import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {CraSharedModule} from '../shared';
import {HomeComponent} from './';

@NgModule({
    imports: [
        CraSharedModule
    ],
    declarations: [
        HomeComponent,
    ],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class CraHomeModule {
}
