package ma.wafa.cream.web.rest.mapper;

import java.util.List;
import java.util.Set;

import ma.wafa.cream.domain.*;
import ma.wafa.cream.web.rest.dto.TacheDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Tache and its DTO TacheDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TacheMapper {

    @Mapping(source = "prospection.id", target = "prospectionId")
    @Mapping(source = "prospection.sujet", target = "prospectionSujet")
    @Mapping(source = "statutTache.id", target = "statutTacheId")
    @Mapping(source = "statutTache.libelle", target = "statutTacheLibelle")
    @Mapping(target = "actions", ignore = true)
    TacheDTO tacheToTacheDTO(Tache tache);

    @Mapping(source = "prospectionId", target = "prospection")
    @Mapping(target = "actions", ignore = true)
    @Mapping(source = "statutTacheId", target = "statutTache")
    Tache tacheDTOToTache(TacheDTO tacheDTO);

  List<TacheDTO> tachesToTacheDTOs(Set<Tache> taches);
  List<TacheDTO> tachesToTacheDTOs(List<Tache> taches);
    
    default Prospection prospectionFromId(Long id) {
        if (id == null) {
            return null;
        }
        Prospection prospection = new Prospection();
        prospection.setId(id);
        return prospection;
    }

    default RefStatutTache refStatutTacheFromId(Long id) {
        if (id == null) {
            return null;
        }
        RefStatutTache refStatutTache = new RefStatutTache();
        refStatutTache.setId(id);
        return refStatutTache;
    }
}
