package ma.wafa.cream.web.rest.mapper;

import ma.wafa.cream.domain.*;
import ma.wafa.cream.web.rest.dto.RefSituationFamilialeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity RefSituationFamiliale and its DTO RefSituationFamilialeDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface RefSituationFamilialeMapper {

    RefSituationFamilialeDTO refSituationFamilialeToRefSituationFamilialeDTO(RefSituationFamiliale refSituationFamiliale);

    @Mapping(target = "personnes", ignore = true)
    RefSituationFamiliale refSituationFamilialeDTOToRefSituationFamiliale(RefSituationFamilialeDTO refSituationFamilialeDTO);
}
