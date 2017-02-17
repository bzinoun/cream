package ma.wafa.cream.web.rest.mapper;

import ma.wafa.cream.domain.*;
import ma.wafa.cream.web.rest.dto.CompagneDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Compagne and its DTO CompagneDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CompagneMapper {

    @Mapping(source = "statutCompagne.id", target = "statutCompagneId")
    @Mapping(source = "statutCompagne.libelle", target = "statutCompagneLibelle")
    CompagneDTO compagneToCompagneDTO(Compagne compagne);

    @Mapping(target = "prospections", ignore = true)
    @Mapping(source = "statutCompagneId", target = "statutCompagne")
    Compagne compagneDTOToCompagne(CompagneDTO compagneDTO);

    default RefStatutCompagne refStatutCompagneFromId(Long id) {
        if (id == null) {
            return null;
        }
        RefStatutCompagne refStatutCompagne = new RefStatutCompagne();
        refStatutCompagne.setId(id);
        return refStatutCompagne;
    }
}
