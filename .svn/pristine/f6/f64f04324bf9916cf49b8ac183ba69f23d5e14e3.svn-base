package ma.wafa.cream.web.rest.dto;

import java.time.LocalDate;

import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Objects;


/**
 * A DTO for the Compagne entity.
 */
public class CompagneDTO implements Serializable {

    private Long id;

    @NotNull
    private String libelle;

    private LocalDate dateDebut;

    private LocalDate dateFin;

    private Long statutCompagneId;

    private String statutCompagneLibelle;
    
    private List<PersonneDTO> personnes = new ArrayList<PersonneDTO>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
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

    public Long getStatutCompagneId() {
        return statutCompagneId ;
    }

    public void setStatutCompagneId(Long refStatutCompagneId) {
        this.statutCompagneId = refStatutCompagneId;
    }

    public String getStatutCompagneLibelle() {
        return statutCompagneLibelle;
    }

    public void setStatutCompagneLibelle(String refStatutCompagneLibelle) {
        this.statutCompagneLibelle = refStatutCompagneLibelle;
    }

    public List<PersonneDTO> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(List<PersonneDTO> personnes) {
		this.personnes = personnes;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CompagneDTO compagneDTO = (CompagneDTO) o;

        if ( ! Objects.equals(id, compagneDTO.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "CompagneDTO{" +
            "id=" + id +
            ", libelle='" + libelle + "'" +
            ", dateDebut='" + dateDebut + "'" +
            ", dateFin='" + dateFin + "'" +
            '}';
    }
}
