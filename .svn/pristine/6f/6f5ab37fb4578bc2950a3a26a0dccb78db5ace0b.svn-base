package ma.wafa.cream.web.rest.mapper;

import java.util.List;
import java.util.Set;

import ma.wafa.cream.domain.Action;
import ma.wafa.cream.domain.Tache;
import ma.wafa.cream.web.rest.dto.ActionDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Mapper for the entity Action and its DTO ActionDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ActionMapper {

	@Mapping(source = "tache.id", target = "tacheId")
	@Mapping(source = "tache.sujet", target = "tacheSujet")
	ActionDTO actionToActionDTO(Action action);

	@Mapping(source = "tacheId", target = "tache")
	Action actionDTOToAction(ActionDTO actionDTO);

	
	
//	 ActionDTO mapActionToActionDTO( Action action);
	Set <ActionDTO> mapActionsToActionDTOs(Set <Action> actions);

	default Tache tacheFromId(Long id) {
		if (id == null) {
			return null;
		}
		Tache tache = new Tache();
		tache.setId(id);
		return tache;
	}
}
