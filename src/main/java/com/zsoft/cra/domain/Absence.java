package com.zsoft.cra.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;


@Document(collection = "jhi_absence")

public class Absence implements Serializable {

    @Id
    @Field("id_absence")
    private String id;

    @Field("beginning_date")
    private LocalDate beginningDate;

    @Field("ending_date")
    private LocalDate endingDate;

    @Field("absence_type")
    private AbsenceType absenceType;

    @Field("comment")
    @Size(min = 0, max = 500)
    private String comment;

    @DBRef
    @Field("user")
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(LocalDate beginningDate) {
        this.beginningDate = beginningDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public AbsenceType getAbsenceType() {
        return absenceType;
    }

    public void setAbsenceType(AbsenceType absenceType) {
        this.absenceType = absenceType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Absence absence = (Absence) o;

        if (id != null ? !id.equals(absence.id) : absence.id != null) return false;
        if (beginningDate != null ? !beginningDate.equals(absence.beginningDate) : absence.beginningDate != null)
            return false;
        if (endingDate != null ? !endingDate.equals(absence.endingDate) : absence.endingDate != null) return false;
        if (absenceType != absence.absenceType) return false;
        if (comment != null ? !comment.equals(absence.comment) : absence.comment != null) return false;
        return user != null ? user.equals(absence.user) : absence.user == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (beginningDate != null ? beginningDate.hashCode() : 0);
        result = 31 * result + (endingDate != null ? endingDate.hashCode() : 0);
        result = 31 * result + (absenceType != null ? absenceType.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Absence{" +
            "id='" + id + '\'' +
            ", beginningDate=" + beginningDate +
            ", endingDate=" + endingDate +
            ", absenceType=" + absenceType +
            ", comment='" + comment + '\'' +
            ", user='" + user + '\'' +
            '}';
    }
}
