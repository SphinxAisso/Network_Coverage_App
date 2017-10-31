package com.zsoft.cra.service.mapper;

import com.zsoft.cra.domain.Absence;
import com.zsoft.cra.service.dto.AbsenceDTO;
import org.mapstruct.Mapper;

import java.util.List;


/**
 * Mapper for the entity Absence and its DTO AbsenceDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AbsenceMapper {


    AbsenceDTO absenceToAbsenceDTO(Absence absence);

    List<AbsenceDTO> absencesToAbsenceDTOs(List<Absence> absences);

    Absence absenceDTOToAbsence(AbsenceDTO absenceDTO);

    List<Absence> absenceDTOsToAbsences(List<AbsenceDTO> absenceDTOs);

    default Absence absenceFromId(String id) {
        if (id == null) {
            return null;
        }
        Absence absence = new Absence();
        absence.setId(id);
        return absence;
    }


}
