package ma.wafa.cream.web.rest.mapper;

import ma.wafa.cream.domain.*;
import ma.wafa.cream.web.rest.dto.RefStatutTacheDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity RefStatutTache and its DTO RefStatutTacheDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface RefStatutTacheMapper {

    RefStatutTacheDTO refStatutTacheToRefStatutTacheDTO(RefStatutTache refStatutTache);

    @Mapping(target = "taches", ignore = true)
    RefStatutTache refStatutTacheDTOToRefStatutTache(RefStatutTacheDTO refStatutTacheDTO);
}
