import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ZsTrackerService } from './../shared/tracker/tracker.service';

import { CraSharedModule } from '../shared';
/* jhipster-needle-add-admin-module-import - JHipster will add admin modules imports here */

import {
    adminState,
    AuditsComponent,
    UserMgmtComponent,
    UserDialogComponent,
    UserDeleteDialogComponent,
    UserMgmtDetailComponent,
    UserMgmtDialogComponent,
    UserMgmtDeleteDialogComponent,
    LogsComponent,
    ZsMetricsMonitoringModalComponent,
    ZsMetricsMonitoringComponent,
    ZsHealthModalComponent,
    ZsHealthCheckComponent,
    ZsConfigurationComponent,
    ZsDocsComponent,
    AuditsService,
    ZsConfigurationService,
    ZsHealthService,
    ZsMetricsService,
    ZsTrackerComponent,
    LogsService,
    UserResolvePagingParams,
    UserResolve,
    UserModalService
} from './';

@NgModule({
    imports: [
        CraSharedModule,
        RouterModule.forChild(adminState),
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
export class CraAdminModule {}
