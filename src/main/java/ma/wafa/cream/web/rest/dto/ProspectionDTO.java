package ma.wafa.cream.web.rest.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;


/**
 * A DTO for the Prospection entity.
 */
public class ProspectionDTO implements Serializable {

    private Long id;

    @NotNull
    private String sujet;

    private String description;

    private LocalDate dateDebut;
    
    private LocalDate dateEcheance;

    private LocalDate dateFin;

    private String immatriculation;

    private String marque;

    private String modele;
    
    private String compagnie;

    
    private LocalDate dateCirculation;

    private String usageLibelle;

    private String codeUsage;

    private String energie;

    private Integer anneeVignette;

    private String user;

    private Long personneId;

    private String personneNom;

    private Long compagneId;

    private String compagneLibelle;

    private Long statutProspectionId;

    private String statutProspectionLibelle;
    
    private Byte categorieContrat;
    
    private Long numPolice; 
    
    private List<TacheDTO> taches ; 
    
    private  List<ActionDTO> actions ; 
    


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
    
    public LocalDate getDateEcheance() {
        return dateEcheance;
    }
    
    public void setDateEcheance(LocalDate dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public LocalDate getDateCirculation() {
        return dateCirculation;
    }
    
    public void setDateCirculation(LocalDate dateCirculation) {
        this.dateCirculation = dateCirculation;
    }
    
    public String getUsageLibelle() {
        return usageLibelle;
    }

    public void setUsageLibelle(String usageLibelle) {
        this.usageLibelle = usageLibelle;
    }

    public String getCodeUsage() {
        return codeUsage;
    }

    public void setCodeUsage(String codeUsage) {
        this.codeUsage = codeUsage;
    }

    public String getEnergie() {
        return energie;
    }

    public void setEnergie(String energie) {
        this.energie = energie;
    }

    public Integer getAnneeVignette() {
        return anneeVignette;
    }

    public void setAnneeVignette(Integer anneeVignette) {
        this.anneeVignette = anneeVignette;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getPersonneId() {
        return personneId;
    }

    public void setPersonneId(Long personneId) {
        this.personneId = personneId;
    }

    public String getPersonneNom() {
        return personneNom;
    }

    public void setPersonneNom(String personneNom) {
        this.personneNom = personneNom;
    }

    public Long getCompagneId() {
        return compagneId;
    }

    public void setCompagneId(Long compagneId) {
        this.compagneId = compagneId;
    }

    public String getCompagneLibelle() {
        return compagneLibelle;
    }

    public void setCompagneLibelle(String compagneLibelle) {
        this.compagneLibelle = compagneLibelle;
    }

    public Long getStatutProspectionId() {
        return statutProspectionId;
    }

    public void setStatutProspectionId(Long refStatutProspectionId) {
        this.statutProspectionId = refStatutProspectionId;
    }

    public String getStatutProspectionLibelle() {
        return statutProspectionLibelle;
    }

    public void setStatutProspectionLibelle(String refStatutProspectionLibelle) {
        this.statutProspectionLibelle = refStatutProspectionLibelle;
    }

    public Byte getCategorieContrat() {
        return categorieContrat;
    }

    public void setCategorieContrat(Byte categorieContrat) {
        this.categorieContrat = categorieContrat;
    }

    public Long getNumPolice() {
        return numPolice;
    }

    public void setNumPolice(Long numPolice) {
        this.numPolice = numPolice;
    }

    public List<TacheDTO> getTaches() {
		return taches;
	}

	public void setTaches(List<TacheDTO> tachesDto) {
		this.taches = tachesDto;
	}

	public List<ActionDTO> getActions() {
		return actions;
	}

	public void setActions(List<ActionDTO> actions) {
		this.actions = actions;
	}

    public String getCompagnie() {
		return compagnie;
	}

	public void setCompagnie(String compagnie) {
		this.compagnie = compagnie;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProspectionDTO prospectionDTO = (ProspectionDTO) o;

        if ( ! Objects.equals(id, prospectionDTO.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "ProspectionDTO{" +
            "id=" + id +
            ", sujet='" + sujet + "'" +
            ", description='" + description + "'" +
            ", dateDebut='" + dateDebut + "'" +
            ", dateFin='" + dateFin + "'" +
            ", immatriculation='" + immatriculation + "'" +
            ", marque='" + marque + "'" +
            ", modele='" + modele + "'" +
            ", usageLibelle='" + usageLibelle + "'" +
            ", codeUsage='" + codeUsage + "'" +
            ", energie='" + energie + "'" +
            ", anneeVignette='" + anneeVignette + "'" +
            ", user='" + user + "'" +
            '}';
    }
}
