package com.zsoft.cra.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Document(collection = "absence")
public class Absence implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * An Absence.
     */




        @Id
        private String id;

        @Field("start_date")
        private LocalDate startDate = null;

        @Field("end_date")
        private LocalDate endDate = null;

        @Field("absence_Type")
        private String absenceType = null;



        public void setId(String id) {
        this.id = id;
        }

        public void setStartDate(LocalDate startDate) {
            this.startDate = startDate;
        }

        public void setEndDate(LocalDate endDate) {
            this.endDate = endDate;
        }

        public void setAbsenceType(String absenceType) {
            this.absenceType = absenceType;
        }

        public String getId() {
        return id;
        }

        public LocalDate getStartDate() { return startDate; }

        public LocalDate getEndDate() {
            return endDate;
        }

        public String getAbsenceType() { return absenceType; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Absence)) return false;
        Absence absence = (Absence) o;
        return Objects.equals(startDate, absence.startDate) &&
            Objects.equals(endDate, absence.endDate) &&
            Objects.equals(absenceType, absence.absenceType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(startDate, endDate, absenceType);
    }

    @Override
    public String toString() {
        return "Absence{" +
            "startDate=" + startDate +
            ", endDate=" + endDate +
            ", absenceType='" + absenceType + '\'' +
            '}';
    }
}

