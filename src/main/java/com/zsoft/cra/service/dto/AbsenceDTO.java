package com.zsoft.cra.service.dto;
import com.zsoft.cra.domain.*;
import javax.validation.constraints.Size;
import java.time.Instant;

    /**
     * A DTO representing an absence
     */
    public class AbsenceDTO {

        private Instant startDate;
        private Instant endDate;
        @Size(max = 25)
        private String absenceType;

        public AbsenceDTO() {
        }

        public AbsenceDTO(Absence absence) {
            this.startDate = absence.getStartDate();
            this.endDate = absence.getEndDate();
            this.absenceType = absence.getAbsenceType();
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
        public String toString() {
            return "AbsenceDTO{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", absenceType='" + absenceType + '\'' +
                '}';
        }
    }
