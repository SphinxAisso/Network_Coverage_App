package com.zsoft.cra.domain;


import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@org.springframework.data.mongodb.core.mapping.Document(collection = "zs_user")
public class Absence extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * An Absence.
     */




        @Field("start_date")
        private Instant startDate = null;

        @Field("end_date")
        private Instant endDate = null;

        @Size(max = 25)
        @Field("absenceType")
        private String absenceType;

        public void setStartDate(Instant startDate) {
            this.startDate = startDate;
        }

        public void setEndDate(Instant endDate) {
            this.endDate = endDate;
        }

        public void setAbsenceType(String absenceType) {
            this.absenceType = absenceType;
        }

        public Instant getStartDate() {
            return startDate;
        }

        public Instant getEndDate() {
            return endDate;
        }

        public String getAbsenceType() {
            return absenceType;
        }

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

