package ma.wafa.cream.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * A Agence.
 */
@Entity
@Table(name = "agence")
@Document(indexName = "agence")
public class Agence implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Column(name = "code_agence")
    private String codeAgence;
    
    @NotNull
    @Column(name = "code_agent")
    private String codeAgent;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCodeAgence() {
        return codeAgence;
    }
    
    public void setCodeAgence(String codeAgence) {
        this.codeAgence = codeAgence;
    }
    
    public String getCodeAgent() {
        return codeAgent;
    }
    
    public void setCodeAgent(String codeAgent) {
        this.codeAgent = codeAgent;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Agence agence = (Agence) o;
        return Objects.equals(id, agence.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
    
    @Override
    public String toString() {
        return "Agence{" + "id=" + id + ", codeAgence='" + codeAgence + "'" + ", codeAgent='" + codeAgent + "'" + '}';
    }
}
