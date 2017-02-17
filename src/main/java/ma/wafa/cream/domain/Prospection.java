package ma.wafa.cream.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * A Prospection.
 */
@Entity
@Table(name = "prospection")
@Document(indexName = "prospection")
public class Prospection implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "sujet", nullable = false)
    private String sujet;

    @Column(name = "description")
    private String description;

    @Column(name = "date_debut")
    private LocalDate dateDebut;
    
    @Column(name = "date_fin")
    private LocalDate dateFin;
    
    @Column(name = "date_echeance")
    private LocalDate dateEcheance;
    
    @Column(name = "immatriculation")
    private String immatriculation;

    @Column(name = "marque")
    private String marque;

    @Column(name = "modele")
    private String modele;
    
    @Column(name = "compagnie")
    private String compagnie;

    @Column(name = "date_circulation")
    private LocalDate dateCirculation;
    
    @Column(name = "usage_libelle")
    private String usageLibelle;

    @Column(name = "code_usage")
    private String codeUsage;

    @Column(name = "energie")
    private String energie;

    @Column(name = "annee_vignette")
    private Integer anneeVignette;
    
    @Column(name = "categorie_contrat")
    private Byte categorieContrat;
    
    @Column(name = "num_police")
    private Long numPolice; 

    @Column(name = "user")
    private String user;

    @ManyToOne
    @JoinColumn(name = "personne_id")
    private Personne personne;

    @ManyToOne
    @JoinColumn(name = "compagne_id")
    private Compagne compagne;

    @OneToMany(mappedBy = "prospection")
    @JsonIgnore
    private Set<Tache> taches = new HashSet<>();
    
    @JsonIgnore
    @OneToMany(cascade  = {CascadeType.ALL}, orphanRemoval= true)
    @JoinColumn(name = "prospection_id")
    private Set<Access> access = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "statut_prospection_id")
    private RefStatutProspection statutProspection;

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

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Compagne getCompagne() {
        return compagne;
    }

    public void setCompagne(Compagne compagne) {
        this.compagne = compagne;
    }

    public Set<Tache> getTaches() {
        return taches;
    }

    public void setTaches(Set<Tache> taches) {
        this.taches = taches;
    }

    public RefStatutProspection getStatutProspection() {
        return statutProspection;
    }

    public void setStatutProspection(RefStatutProspection refStatutProspection) {
        this.statutProspection = refStatutProspection;
    }
    
    public Set<Access> getAccess() {
        return access;
    }

    public void setAccess(Set<Access> access) {
        this.access = access;
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
        Prospection prospection = (Prospection) o;
        return Objects.equals(id, prospection.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Prospection{" +
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
