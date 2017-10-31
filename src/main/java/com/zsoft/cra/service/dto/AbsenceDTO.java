package com.zsoft.cra.service.dto;

import com.zsoft.cra.domain.AbsenceType;

import javax.validation.constraints.Size;
import java.time.LocalDate;

public class AbsenceDTO {

    private String id;


    private LocalDate beginningDate;


    private LocalDate endingDate;


    private AbsenceType absenceType;

    @Size(min = 0, max = 500)
    private String comment;


    private String userLogin;


    public AbsenceDTO() {
        // Empty constructor needed by mapstruct
    }

    public AbsenceDTO(String id, LocalDate beginningDate, LocalDate endingDate, AbsenceType absenceType, String comment, String userLogin) {
        this.id = id;
        this.beginningDate = beginningDate;
        this.endingDate = endingDate;
        this.absenceType = absenceType;
        this.comment = comment;
        this.userLogin = userLogin;
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

    public String getUserLogin() {
        return userLogin;
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

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public String toString() {
        return "AbsenceDTO{" +
            "id='" + id + '\'' +
            ", beginningDate=" + beginningDate +
            ", endingDate=" + endingDate +
            ", absenceType=" + absenceType +
            ", comment='" + comment + '\'' +
            ", userLogin=" + userLogin +
            '}';
    }
}
