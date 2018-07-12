import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

//import { createRequestOption } from '../model/request-util';
import {Absence} from "./absence.model";
import {SERVER_API_URL} from "../app.constants";

@Injectable()
export class AbsenceService {
    private resourceUrl = SERVER_API_URL + 'api/users';

    constructor(private http: HttpClient) { }

    create(absence: Absence): Observable<HttpResponse<Absence>> {
        return this.http.post<Absence>(this.resourceUrl, absence, { observe: 'response' });
    }

}
