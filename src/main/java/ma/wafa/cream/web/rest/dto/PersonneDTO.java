package ma.wafa.cream.web.rest.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import ma.wafa.cream.domain.enumeration.TypePersonne;

/**
 * A DTO for the Personne entity.
 */
public class PersonneDTO implements Serializable {

    private Long id;

    @NotNull
    private String nom;

    private String numeroCIN;

    private String rc;
    
    private String codeAgence;
    
    private String telephone;

    private String prenom;

    private String civilite;

    private TypePersonne type;

    private String titre;

    private LocalDate dateNaissance;

    private String numeroPatente;

    private String raisonSociale;

    private String email;

    private String ville;

    private LocalDate dateObtentionPermis;

    private String numeroPermis;

    private Long situationFamilialeId;

    private String situationFamilialeLibelle;

    private Long secteurActiviteId;

    private String secteurActiviteLibelle;
    
    private String _prospectionLibelle;
    
    private String numeroContrat;

    private Boolean client;

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
        this.codeAgence = codeAgence;
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

    public Long getSituationFamilialeId() {
        return situationFamilialeId;
    }

    public void setSituationFamilialeId(Long refSituationFamilialeId) {
        this.situationFamilialeId = refSituationFamilialeId;
    }

    public String getSituationFamilialeLibelle() {
        return situationFamilialeLibelle;
    }

    public void setSituationFamilialeLibelle(String refSituationFamilialeLibelle) {
        this.situationFamilialeLibelle = refSituationFamilialeLibelle;
    }

    public Long getSecteurActiviteId() {
        return secteurActiviteId;
    }

    public void setSecteurActiviteId(Long refSecteurActiviteId) {
        this.secteurActiviteId = refSecteurActiviteId;
    }

    public String getSecteurActiviteLibelle() {
        return secteurActiviteLibelle;
    }

    public void setSecteurActiviteLibelle(String refSecteurActiviteLibelle) {
        this.secteurActiviteLibelle = refSecteurActiviteLibelle;
    }

    public String get_prospectionLibelle() {
		return _prospectionLibelle;
	}

	public void set_prospectionLibelle(String _prospectionLibelle) {
		this._prospectionLibelle = _prospectionLibelle;
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

        PersonneDTO personneDTO = (PersonneDTO) o;

        if ( ! Objects.equals(id, personneDTO.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "PersonneDTO{" +
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
