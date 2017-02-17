package ma.wafa.cream.web.rest.mapper;

import ma.wafa.cream.domain.*;
import ma.wafa.cream.web.rest.dto.RefSecteurActiviteDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity RefSecteurActivite and its DTO RefSecteurActiviteDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface RefSecteurActiviteMapper {

    RefSecteurActiviteDTO refSecteurActiviteToRefSecteurActiviteDTO(RefSecteurActivite refSecteurActivite);

    @Mapping(target = "personnes", ignore = true)
    RefSecteurActivite refSecteurActiviteDTOToRefSecteurActivite(RefSecteurActiviteDTO refSecteurActiviteDTO);
}
