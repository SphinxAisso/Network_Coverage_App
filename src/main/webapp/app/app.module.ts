import {ZsLoginModule} from './zs-login';
import './vendor.ts';

import {Injector, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HTTP_INTERCEPTORS} from '@angular/common/http';
import {Ng2Webstorage} from 'ngx-webstorage';
import {JhiEventManager} from 'ng-jhipster';

import {AuthExpiredInterceptor} from './blocks/interceptor/auth-expired.interceptor';
import {ErrorHandlerInterceptor} from './blocks/interceptor/errorhandler.interceptor';
import {NotificationInterceptor} from './blocks/interceptor/notification.interceptor';
import {CraSharedModule, StateStorageService, UserRouteAccessService} from './shared';
import {CraAppRoutingModule} from './app-routing.module';
import {CraHomeModule} from './home';
import {CraAdminModule} from './admin/admin.module';
import {CraAccountModule} from './account/account.module';
import {CraEntityModule} from './entities/entity.module';
import {PaginationConfig} from './blocks/config/uib-pagination.config';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import {
    ActiveMenuDirective,
    ErrorComponent,
    FooterComponent,
    NavbarComponent,
    PageRibbonComponent,
    ProfileService,
    ZsMainComponent
} from './layouts';
import {ZsSidebarComponent} from './layouts/zs-sidebar/zs-sidebar.component';
import {ZsSidebarHeaderComponent} from './layouts/zs-sidebar-header/zs-sidebar-header.component';
import {ZS_SIDEBAR_NAV, ZsSidebarNavComponent} from './layouts/zs-sidebar-nav/zs-sidebar-nav.component';
import {ZsSidebarMinimizerComponent} from './layouts/zs-sidebar-minimizer/zs-sidebar-minimizer.component';
import {SIDEBAR_TOGGLE_DIRECTIVES} from './layouts/zs-sidebar/sidebar.directive';
import {NAV_DROPDOWN_DIRECTIVES} from './layouts/zs-sidebar/nav-dropdown.directive';
import {ZsBreadcrumbComponent} from './zs-breadcrumb/zs-breadcrumb.component';
import {FullLayoutComponent} from './layouts/full-layout/full-layout.component';
import {SimpleLayoutComponent} from './layouts/simple-layout/simple-layout.component';

@NgModule({
    imports: [
        BrowserModule,
        CraAppRoutingModule,
        Ng2Webstorage.forRoot({prefix: 'zs', separator: '-'}),
        CraSharedModule,
        CraHomeModule,
        CraAdminModule,
        CraAccountModule,
        CraEntityModule,
        ZsLoginModule
        // jhipster-needle-angular-add-module JHipster will add new module here
    ],
    declarations: [
        ZsMainComponent,
        NavbarComponent,
        ErrorComponent,
        PageRibbonComponent,
        ActiveMenuDirective,
        FooterComponent,
        ZsSidebarComponent,
        ZsSidebarHeaderComponent,
        ZsSidebarNavComponent,
        ZsSidebarMinimizerComponent,
        ZS_SIDEBAR_NAV,
        SIDEBAR_TOGGLE_DIRECTIVES,
        NAV_DROPDOWN_DIRECTIVES,
        ZsBreadcrumbComponent,
        FullLayoutComponent,
        SimpleLayoutComponent
    ],
    providers: [
        ProfileService,
        PaginationConfig,
        UserRouteAccessService,
        {
            provide: HTTP_INTERCEPTORS,
            useClass: AuthExpiredInterceptor,
            multi: true,
            deps: [
                StateStorageService,
                Injector
            ]
        },
        {
            provide: HTTP_INTERCEPTORS,
            useClass: ErrorHandlerInterceptor,
            multi: true,
            deps: [
                JhiEventManager
            ]
        },
        {
            provide: HTTP_INTERCEPTORS,
            useClass: NotificationInterceptor,
            multi: true,
            deps: [
                Injector
            ]
        }
    ],
    bootstrap: [ZsMainComponent]
})
export class CraAppModule {
}
