package ma.wafa.cream.web.rest.mapper;

import ma.wafa.cream.domain.*;
import ma.wafa.cream.web.rest.dto.ProspectionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Prospection and its DTO ProspectionDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ProspectionMapper {

    @Mapping(source = "personne.id", target = "personneId")
    @Mapping(source = "personne.nom", target = "personneNom")
    @Mapping(source = "compagne.id", target = "compagneId")
    @Mapping(source = "compagne.libelle", target = "compagneLibelle")
    @Mapping(source = "statutProspection.id", target = "statutProspectionId")
    @Mapping(source = "statutProspection.libelle", target = "statutProspectionLibelle")
    @Mapping(target = "taches", ignore = true)
    ProspectionDTO prospectionToProspectionDTO(Prospection prospection);

    @Mapping(source = "personneId", target = "personne")
    @Mapping(source = "compagneId", target = "compagne")
    @Mapping(target = "taches", ignore = true)
    @Mapping(source = "statutProspectionId", target = "statutProspection")
    Prospection prospectionDTOToProspection(ProspectionDTO prospectionDTO);

    default Personne personneFromId(Long id) {
        if (id == null) {
            return null;
        }
        Personne personne = new Personne();
        personne.setId(id);
        return personne;
    }

    default Compagne compagneFromId(Long id) {
        if (id == null) {
            return null;
        }
        Compagne compagne = new Compagne();
        compagne.setId(id);
        return compagne;
    }

    default RefStatutProspection refStatutProspectionFromId(Long id) {
        if (id == null) {
            return null;
        }
        RefStatutProspection refStatutProspection = new RefStatutProspection();
        refStatutProspection.setId(id);
        return refStatutProspection;
    }
}
