package ma.wafa.cream.web.rest.mapper;

import ma.wafa.cream.domain.*;
import ma.wafa.cream.web.rest.dto.RefStatutCompagneDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity RefStatutCompagne and its DTO RefStatutCompagneDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface RefStatutCompagneMapper {

    RefStatutCompagneDTO refStatutCompagneToRefStatutCompagneDTO(RefStatutCompagne refStatutCompagne);

    @Mapping(target = "compagnes", ignore = true)
    RefStatutCompagne refStatutCompagneDTOToRefStatutCompagne(RefStatutCompagneDTO refStatutCompagneDTO);
}
