package ma.wafa.cream.web.rest.mapper;

import ma.wafa.cream.domain.*;
import ma.wafa.cream.web.rest.dto.PerferenceDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Perference and its DTO PerferenceDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PerferenceMapper {

    PerferenceDTO perferenceToPerferenceDTO(Perference perference);

    Perference perferenceDTOToPerference(PerferenceDTO perferenceDTO);
}
