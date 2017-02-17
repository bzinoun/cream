package ma.wafa.cream.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.elasticsearch.annotations.Document;

@Entity
@Table(name = "access")
@Document(indexName = "access")
public class Access implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "user")
    private String user;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUser() {
        return user;
    }
    
    public void setUser(String userName) {
        this.user = userName;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Access access = (Access) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(id, access.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
