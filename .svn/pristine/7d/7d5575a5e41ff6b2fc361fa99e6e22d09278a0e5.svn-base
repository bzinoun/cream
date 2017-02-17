package ma.wafa.cream.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * A Agent.
 */
@Entity
@Table(name = "agent")
@Document(indexName = "agent")
public class Agent implements Serializable {
    
    @Id
    @Column(name = "code_agent")
    private String codeAgent;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "type_intermediaire")
    private String typeIntermediaire;
    
    @Column(name = "promotion")
    private String promotion;
    
    @Column(name = "manager_commercial_senior")
    private String managerCommercialSenior;
    
    @NotNull
    @Column(name = "manager_commercial_junior")
    private String managerCommercialJunior;
    
    @Column(name = "ville")
    private String ville;
    
    @Column(name = "adresse")
    private String adresse;
    
    @Column(name = "quartier")
    private String quartier;
    
    public String getCodeAgent() {
        return codeAgent;
    }

    public void setCodeAgent(String codeAgent) {
        this.codeAgent = codeAgent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeIntermediaire() {
        return typeIntermediaire;
    }

    public void setTypeIntermediaire(String typeIntermediaire) {
        this.typeIntermediaire = typeIntermediaire;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public String getManagerCommercialSenior() {
        return managerCommercialSenior;
    }

    public void setManagerCommercialSenior(String managerCommercialSenior) {
        this.managerCommercialSenior = managerCommercialSenior;
    }

    public String getManagerCommercialJunior() {
        return managerCommercialJunior;
    }

    public void setManagerCommercialJunior(String managerCommercialJunior) {
        this.managerCommercialJunior = managerCommercialJunior;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Agent agent = (Agent) o;
        return Objects.equals(codeAgent, agent.codeAgent);
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(codeAgent);
    }
    
    @Override
    public String toString() {
        return "Agent [codeAgent=" + codeAgent + ", managerCommercialSenior=" + managerCommercialSenior + ", managerCommercialJunior="
                + managerCommercialJunior + ", ville=" + ville + ", quartier=" + quartier + "]";
    }
}
