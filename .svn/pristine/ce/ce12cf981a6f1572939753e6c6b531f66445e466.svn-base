package ma.wafa.cream.web.rest.dto;

import java.time.LocalDate;

import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Objects;

import javax.persistence.Lob;

import ma.wafa.cream.domain.enumeration.TypeTache;

/**
 * A DTO for the Tache entity.
 */
public class TacheDTO implements Serializable {

    private Long id;

    @NotNull
    private String sujet;

    private String description;

    private LocalDate dateDebut;

    private LocalDate dateFin;

    @NotNull
    private TypeTache type;

    @Lob
    private byte[] pieceJointe;

    private String pieceJointeContentType;

    private String user;

    private Long prospectionId;

    private String prospectionSujet;

    private Long statutTacheId;

    private String statutTacheLibelle;
    
    private List<ActionDTO> actions ; 

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

    public TypeTache getType() {
        return type;
    }

    public void setType(TypeTache type) {
        this.type = type;
    }

    public byte[] getPieceJointe() {
        return pieceJointe;
    }

    public void setPieceJointe(byte[] pieceJointe) {
        this.pieceJointe = pieceJointe;
    }

    public String getPieceJointeContentType() {
        return pieceJointeContentType;
    }

    public void setPieceJointeContentType(String pieceJointeContentType) {
        this.pieceJointeContentType = pieceJointeContentType;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getProspectionId() {
        return prospectionId;
    }

    public void setProspectionId(Long prospectionId) {
        this.prospectionId = prospectionId;
    }

    public String getProspectionSujet() {
        return prospectionSujet;
    }

    public void setProspectionSujet(String prospectionSujet) {
        this.prospectionSujet = prospectionSujet;
    }

    public Long getStatutTacheId() {
        return statutTacheId;
    }

    public void setStatutTacheId(Long refStatutTacheId) {
        this.statutTacheId = refStatutTacheId;
    }

    public String getStatutTacheLibelle() {
        return statutTacheLibelle;
    }

    public void setStatutTacheLibelle(String refStatutTacheLibelle) {
        this.statutTacheLibelle = refStatutTacheLibelle;
    }

    public List<ActionDTO> getActions() {
		return actions;
	}

	public void setActions(List<ActionDTO> actions) {
		this.actions = actions;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TacheDTO tacheDTO = (TacheDTO) o;

        if ( ! Objects.equals(id, tacheDTO.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "TacheDTO{" +
            "id=" + id +
            ", sujet='" + sujet + "'" +
            ", description='" + description + "'" +
            ", dateDebut='" + dateDebut + "'" +
            ", dateFin='" + dateFin + "'" +
            ", type='" + type + "'" +
            ", pieceJointe='" + pieceJointe + "'" +
            ", user='" + user + "'" +
            '}';
    }
}
