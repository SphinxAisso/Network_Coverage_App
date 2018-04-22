import {Component} from '@angular/core';
import {ActivatedRoute, NavigationEnd, Router} from '@angular/router';
import 'rxjs/add/operator/filter';

@Component({
    selector: 'zs-breadcrumbs',
    template: `
        <ng-template ngFor let-breadcrumb [ngForOf]="breadcrumbs" let-last=last>
            <li class="breadcrumb-item"
                *ngIf="breadcrumb.label.title&&breadcrumb.url.substring(breadcrumb.url.length-1) == '/'||breadcrumb.label.title&&last"
                [ngClass]="{active: last}">
                <a *ngIf="!last" [routerLink]="breadcrumb.url">{{breadcrumb.label.title}}</a>
                <span *ngIf="last" [routerLink]="breadcrumb.url">{{breadcrumb.label.title}}</span>
            </li>
        </ng-template>`
})
export class ZsBreadcrumbComponent {
    breadcrumbs: Array<Object>;

    constructor(private router: Router,
                private route: ActivatedRoute) {
        this.router.events.filter((event) => event instanceof NavigationEnd).subscribe((event) => {
            this.breadcrumbs = [];
            let currentRoute = this.route.root, url: String = '';
            do {
                const childrenRoutes = currentRoute.children;
                currentRoute = null;
                // tslint:disable-next-line:no-shadowed-variable
                childrenRoutes.forEach((route) => {
                    console.log('URL ' + route.snapshot.url);
                    if (route.outlet === 'primary') {
                        const routeSnapshot = route.snapshot;

                        if (route.snapshot.url.length !== 0) {
                            url += '/' + routeSnapshot.url.map((segment) => segment.path).join('/');
                            this.breadcrumbs.push({
                                label: {title: route.snapshot.url},
                                url: url
                            });
                        }
                        currentRoute = route;
                    }
                });
            } while (currentRoute);
        });
    }
}
