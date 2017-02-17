package ma.wafa.cream.web.rest.mapper;

import ma.wafa.cream.domain.*;
import ma.wafa.cream.web.rest.dto.PersonneDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Personne and its DTO PersonneDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PersonneMapper {

    @Mapping(source = "situationFamiliale.id", target = "situationFamilialeId")
    @Mapping(source = "situationFamiliale.libelle", target = "situationFamilialeLibelle")
    @Mapping(source = "secteurActivite.id", target = "secteurActiviteId")
    @Mapping(source = "secteurActivite.libelle", target = "secteurActiviteLibelle")
    PersonneDTO personneToPersonneDTO(Personne personne);

    @Mapping(target = "prospections", ignore = true)
    @Mapping(source = "situationFamilialeId", target = "situationFamiliale")
    @Mapping(source = "secteurActiviteId", target = "secteurActivite")
    Personne personneDTOToPersonne(PersonneDTO personneDTO);

    default RefSituationFamiliale refSituationFamilialeFromId(Long id) {
        if (id == null) {
            return null;
        }
        RefSituationFamiliale refSituationFamiliale = new RefSituationFamiliale();
        refSituationFamiliale.setId(id);
        return refSituationFamiliale;
    }

    default RefSecteurActivite refSecteurActiviteFromId(Long id) {
        if (id == null) {
            return null;
        }
        RefSecteurActivite refSecteurActivite = new RefSecteurActivite();
        refSecteurActivite.setId(id);
        return refSecteurActivite;
    }
}
