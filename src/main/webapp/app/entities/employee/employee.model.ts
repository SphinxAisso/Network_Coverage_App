import {BaseEntity, User} from './../../shared';

export class Employee extends User implements BaseEntity {

    public id?: any;
    public code?: string;

    constructor(id?: any,
                code?: string,
                login?: string,
                firstName?: string,
                lastName?: string,
                email?: string,
                activated?: Boolean,
                langKey?: string,
                authorities?: any[],
                createdBy?: string,
                createdDate?: Date,
                lastModifiedBy?: string,
                lastModifiedDate?: Date,
                password?: string) {
        super(null, login, firstName, lastName, email, activated, langKey, authorities, createdBy, createdDate, lastModifiedBy, lastModifiedDate, password);
        this.id = id ? id : null;
        this.code = code ? code : null;
    }
}
