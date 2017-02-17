package ma.wafa.cream.web.rest.mapper;

import ma.wafa.cream.domain.*;
import ma.wafa.cream.web.rest.dto.RefStatutProspectionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity RefStatutProspection and its DTO RefStatutProspectionDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface RefStatutProspectionMapper {

    RefStatutProspectionDTO refStatutProspectionToRefStatutProspectionDTO(RefStatutProspection refStatutProspection);

    @Mapping(target = "prospections", ignore = true)
    RefStatutProspection refStatutProspectionDTOToRefStatutProspection(RefStatutProspectionDTO refStatutProspectionDTO);
}
