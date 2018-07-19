import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Absence} from "./absence.model";
import { SERVER_API_URL } from '../app.constants';


@Injectable()
export class AbsenceService {
    private resourceUrl = SERVER_API_URL + 'api/absences';

    constructor(private http: HttpClient) { }

   /* create(absence: Absence): Observable<HttpResponse<Absence>> {
        return this.http.post<Absence>(this.resourceUrl, absence, { observe: 'response' });
    }*/

    update(absence: Absence): Observable<HttpResponse<Absence>> {
        return this.http.put<Absence>(this.resourceUrl, absence, { observe: 'response' });
    }

    find(login: string): Observable<HttpResponse<Absence>> {
        return this.http.get<Absence>(`${this.resourceUrl}/${login}`, { observe: 'response' });
    }


    delete(id: string): Observable<HttpResponse<any>> {
        return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

}
