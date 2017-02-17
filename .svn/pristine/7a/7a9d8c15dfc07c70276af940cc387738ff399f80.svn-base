package ma.wafa.cream.web.rest.dto;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import ma.wafa.cream.domain.enumeration.TypeAction;

/**
 * A DTO for the Action entity.
 */
public class ActionDTO implements Serializable {

    private Long id;

    @NotNull
    private String sujet;

    private String description;

    private LocalDate dateDebut;

    private LocalDate dateFin;

    private TypeAction typeAction;

    private String user;
    private String decision;

    private Long tacheId;
    private Long _prospectionId;
    private String _numeroContrat;

    private String tacheSujet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public TypeAction getTypeAction() {
        return typeAction;
    }

    public void setTypeAction(TypeAction typeAction) {
        this.typeAction = typeAction;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public Long getTacheId() {
        return tacheId;
    }

    public void setTacheId(Long tacheId) {
        this.tacheId = tacheId;
    }

    public String getTacheSujet() {
        return tacheSujet;
    }

    public void setTacheSujet(String tacheSujet) {
        this.tacheSujet = tacheSujet;
    }

    public String get_numeroContrat() {
		return _numeroContrat;
	}

	public void set_numeroContrat(String _numeroContrat) {
		this._numeroContrat = _numeroContrat;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ActionDTO actionDTO = (ActionDTO) o;

        if ( ! Objects.equals(id, actionDTO.id)) return false;

        return true;
    }

    public Long get_prospectionId() {
		return _prospectionId;
	}

	public void set_prospectionId(Long _prospectionId) {
		this._prospectionId = _prospectionId;
	}

	@Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "ActionDTO{" +
            "id=" + id +
            ", sujet='" + sujet + "'" +
            ", description='" + description + "'" +
            ", dateDebut='" + dateDebut + "'" +
            ", dateFin='" + dateFin + "'" +
            ", typeAction='" + typeAction + "'" +
            ", user='" + user + "'" +
            '}';
    }
}
