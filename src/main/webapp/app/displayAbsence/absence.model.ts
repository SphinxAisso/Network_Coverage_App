export class Absence {

    public id? : string;
    public startDate? : Date;
    public endDate? : Date;
    public absenceType? : string;


    constructor(
        id?: string,
        startDate?: Date,
        endDate?: Date,
        absenceType?: string
    ) {
        this.id = id ? id : null;
        this.startDate = startDate ? startDate : null;
        this.endDate = endDate ? endDate : null;
        this.absenceType = absenceType ? absenceType : null;
    }

}
