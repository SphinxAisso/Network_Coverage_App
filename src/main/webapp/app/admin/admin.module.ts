import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {CraSharedModule, ZsTrackerService} from '../shared';
import {
    AuditsComponent,
    AuditsService,
    LogsComponent,
    LogsService,
    UserDeleteDialogComponent,
    UserDialogComponent,
    UserMgmtComponent,
    UserMgmtDeleteDialogComponent,
    UserMgmtDetailComponent,
    UserMgmtDialogComponent,
    UserModalService,
    UserResolve,
    UserResolvePagingParams,
    ZsConfigurationComponent,
    ZsConfigurationService,
    ZsDocsComponent,
    ZsHealthCheckComponent,
    ZsHealthModalComponent,
    ZsHealthService,
    ZsMetricsMonitoringComponent,
    ZsMetricsMonitoringModalComponent,
    ZsMetricsService,
    ZsTrackerComponent
} from './';
import {RouterModule} from '@angular/router';

/* jhipster-needle-add-admin-module-import - JHipster will add admin modules imports here */

@NgModule({
    imports: [
        CraSharedModule,
        RouterModule
        /* jhipster-needle-add-admin-module - JHipster will add admin modules here */
    ],
    declarations: [
        AuditsComponent,
        UserMgmtComponent,
        UserDialogComponent,
        UserDeleteDialogComponent,
        UserMgmtDetailComponent,
        UserMgmtDialogComponent,
        UserMgmtDeleteDialogComponent,
        LogsComponent,
        ZsConfigurationComponent,
        ZsHealthCheckComponent,
        ZsHealthModalComponent,
        ZsDocsComponent,
        ZsTrackerComponent,
        ZsMetricsMonitoringComponent,
        ZsMetricsMonitoringModalComponent
    ],
    exports: [
        UserMgmtComponent,
        UserDialogComponent,
        UserDeleteDialogComponent,
        UserMgmtDetailComponent,
        UserMgmtDialogComponent,
        UserMgmtDeleteDialogComponent
    ],
    entryComponents: [
        UserMgmtDialogComponent,
        UserMgmtDeleteDialogComponent,
        ZsHealthModalComponent,
        ZsMetricsMonitoringModalComponent,
    ],
    providers: [
        AuditsService,
        ZsConfigurationService,
        ZsHealthService,
        ZsMetricsService,
        LogsService,
        ZsTrackerService,
        UserResolvePagingParams,
        UserResolve,
        UserModalService
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class CraAdminModule {
}
