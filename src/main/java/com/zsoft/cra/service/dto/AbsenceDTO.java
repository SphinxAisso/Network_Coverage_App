package com.zsoft.cra.service.dto;
import com.zsoft.cra.domain.*;
import java.time.LocalDate;

/**
     * A DTO representing an absence
     */
    public class AbsenceDTO {

        private String id;
        private LocalDate startDate;
        private LocalDate endDate;
        private String absenceType;

        public AbsenceDTO() {
        }

        public AbsenceDTO(Absence absence) {
            this.startDate = absence.getStartDate();
            this.endDate = absence.getEndDate();
            this.absenceType = absence.getAbsenceType();
        }

        public String getId() {
        return id;
    }

        public void setId(String id) {
        this.id = id;
    }

        public LocalDate getStartDate() { return startDate; }

        public LocalDate getEndDate() { return endDate; }

        public String getAbsenceType() { return absenceType; }


    @Override
        public String toString() {
            return "AbsenceDTO{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", absenceType='" + absenceType + '\'' +
                '}';
        }
    }
