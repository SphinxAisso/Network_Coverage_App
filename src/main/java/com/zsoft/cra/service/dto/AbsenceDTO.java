package com.zsoft.cra.service.dto;

import com.zsoft.cra.domain.AbsenceType;
import com.zsoft.cra.domain.User;

import javax.validation.constraints.Size;
import java.time.LocalDate;

public class AbsenceDTO {

    private String id;


    private LocalDate beginningDate;


    private LocalDate endingDate;


    private AbsenceType absenceType;

    @Size(min = 0, max = 500)
    private String comment;


    private User user;


    public AbsenceDTO(String id, LocalDate beginningDate, LocalDate endingDate, AbsenceType absenceType, String comment, User user) {
        this.id = id;
        this.beginningDate = beginningDate;
        this.endingDate = endingDate;
        this.absenceType = absenceType;
        this.comment = comment;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public LocalDate getBeginningDate() {
        return beginningDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public AbsenceType getAbsenceType() {
        return absenceType;
    }

    public String getComment() {
        return comment;
    }

    public User getUser() {
        return user;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBeginningDate(LocalDate beginningDate) {
        this.beginningDate = beginningDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public void setAbsenceType(AbsenceType absenceType) {
        this.absenceType = absenceType;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "AbsenceDTO{" +
            "id='" + id + '\'' +
            ", beginningDate=" + beginningDate +
            ", endingDate=" + endingDate +
            ", absenceType=" + absenceType +
            ", comment='" + comment + '\'' +
            ", user=" + user +
            '}';
    }
}
