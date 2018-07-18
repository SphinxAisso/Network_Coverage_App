import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

//import { createRequestOption } from '../model/request-util';
import {SERVER_API_URL} from "../app.constants";

@Injectable()
export class DisplayAbsenceService {
   // private resourceUrl = SERVER_API_URL + 'api/absences';

    constructor(private http: HttpClient) { }

    getAbsence(): Observable<any>{
        // return this.http.post(this.resourceUrl, absence, { observe: 'response' });
        return this.http.get(SERVER_API_URL + 'api/absences');
    }

}
