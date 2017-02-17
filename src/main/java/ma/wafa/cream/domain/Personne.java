package ma.wafa.cream.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.time.LocalDate;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import ma.wafa.cream.domain.enumeration.TypePersonne;

/**
 * A Personne.
 */
@Entity
@Table(name = "personne")
@Document(indexName = "personne")
public class Personne implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "numero_cin")
    private String numeroCIN;

    @Column(name = "rc")
    private String rc;
    
    @Column(name = "code_agence")
    private String codeAgence;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "civilite")
    private String civilite;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TypePersonne type;

    @Column(name = "titre")
    private String titre;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @Column(name = "numero_patente")
    private String numeroPatente;

    @Column(name = "raison_sociale")
    private String raisonSociale;

    @Column(name = "email")
    private String email;

    @Column(name = "ville")
    private String ville;
    
    @Column(name = "numero_contrat")
    private String numeroContrat;

    @Column(name = "is_client")
    private Boolean client;
    
    @Column(name = "date_obtention_permis")
    private LocalDate dateObtentionPermis;

    @Column(name = "numero_permis")
    private String numeroPermis;

    @OneToMany(mappedBy = "personne")
    @JsonIgnore
    private Set<Prospection> prospections = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "situation_familiale_id")
    private RefSituationFamiliale situationFamiliale;

    @ManyToOne
    @JoinColumn(name = "secteur_activite_id")
    private RefSecteurActivite secteurActivite;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumeroCIN() {
        return numeroCIN;
    }

    public void setNumeroCIN(String numeroCIN) {
        this.numeroCIN = numeroCIN;
    }

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }

    public String getCodeAgence() {
        return codeAgence;
    }
    
    public void setCodeAgence(String codeAgence) {
        this.codeAgence= codeAgence;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public TypePersonne getType() {
        return type;
    }

    public void setType(TypePersonne type) {
        this.type = type;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getNumeroPatente() {
        return numeroPatente;
    }

    public void setNumeroPatente(String numeroPatente) {
        this.numeroPatente = numeroPatente;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public LocalDate getDateObtentionPermis() {
        return dateObtentionPermis;
    }

    public void setDateObtentionPermis(LocalDate dateObtentionPermis) {
        this.dateObtentionPermis = dateObtentionPermis;
    }

    public String getNumeroPermis() {
        return numeroPermis;
    }

    public void setNumeroPermis(String numeroPermis) {
        this.numeroPermis = numeroPermis;
    }

    public Set<Prospection> getProspections() {
        return prospections;
    }

    public void setProspections(Set<Prospection> prospections) {
        this.prospections = prospections;
    }

    public RefSituationFamiliale getSituationFamiliale() {
        return situationFamiliale;
    }

    public void setSituationFamiliale(RefSituationFamiliale refSituationFamiliale) {
        this.situationFamiliale = refSituationFamiliale;
    }

    public RefSecteurActivite getSecteurActivite() {
        return secteurActivite;
    }

    public void setSecteurActivite(RefSecteurActivite refSecteurActivite) {
        this.secteurActivite = refSecteurActivite;
    }

    public String getNumeroContrat() {
		return numeroContrat;
	}

	public void setNumeroContrat(String numeroContrat) {
		this.numeroContrat = numeroContrat;
	}

	public Boolean getClient() {
		return client;
	}

	public void setClient(Boolean client) {
		this.client = client;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Personne personne = (Personne) o;
        return Objects.equals(id, personne.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Personne{" +
            "id=" + id +
            ", nom='" + nom + "'" +
            ", numeroCIN='" + numeroCIN + "'" +
            ", rc='" + rc + "'" +
            ", telephone='" + telephone + "'" +
            ", prenom='" + prenom + "'" +
            ", civilite='" + civilite + "'" +
            ", type='" + type + "'" +
            ", titre='" + titre + "'" +
            ", dateNaissance='" + dateNaissance + "'" +
            ", numeroPatente='" + numeroPatente + "'" +
            ", raisonSociale='" + raisonSociale + "'" +
            ", email='" + email + "'" +
            ", ville='" + ville + "'" +
            ", dateObtentionPermis='" + dateObtentionPermis + "'" +
            ", numeroPermis='" + numeroPermis + "'" +
            '}';
    }

    
}
