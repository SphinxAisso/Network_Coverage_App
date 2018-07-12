package com.zsoft.cra.service.mapper;

import com.zsoft.cra.domain.Absence;
import com.zsoft.cra.service.dto.AbsenceDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Mapper for the entity User and its DTO called UserDTO.
 *
 * Normal mappers are generated using MapStruct, this one is hand-coded as MapStruct
 * support is still in beta, and requires a manual step with an IDE.
 */
@Service
public class AbsenceMapper {

    public AbsenceDTO userToUserDTO(Absence absence) {
        return new AbsenceDTO(absence);
    }

    public List<AbsenceDTO> absencesToAbsenceDTOs(List<Absence> absences) {
        return absences.stream()
            .filter(Objects::nonNull)
            .map(this::userToUserDTO)
            .collect(Collectors.toList());
    }

    public Absence absenceDTOToAbsence(AbsenceDTO absenceDTO) {
        if (absenceDTO == null) {
            return null;
        } else {
            Absence absence = new Absence();
            absence.setStartDate(absenceDTO.getStartDate());
            absence.setEndDate(absenceDTO.getEndDate());
            absence.setAbsenceType(absenceDTO.getAbsenceType());
            return absence;
        }
    }

    public List<Absence> absenceDTOsToAbsences (List<AbsenceDTO> absenceDTOs) {
        return absenceDTOs.stream()
            .filter(Objects::nonNull)
            .map(this::absenceDTOToAbsence)
            .collect(Collectors.toList());
    }
}
