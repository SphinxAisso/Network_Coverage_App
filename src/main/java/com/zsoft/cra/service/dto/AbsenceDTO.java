package com.zsoft.cra.service.dto;
import com.zsoft.cra.domain.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
     * A DTO representing an absence
     */
    public class AbsenceDTO {

        private LocalDate startDate;
        private LocalDate endDate;
        @Size(max = 25)
        private String absenceType;

        public AbsenceDTO() {
        }

        public AbsenceDTO(Absence absence) {
            this.startDate = absence.getStartDate();
            this.endDate = absence.getEndDate();
            this.absenceType = absence.getAbsenceType();
        }

        public LocalDate getStartDate() {
            return startDate;
        }

        public LocalDate getEndDate() { return endDate; }

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
