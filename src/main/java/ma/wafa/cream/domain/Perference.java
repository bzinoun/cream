package ma.wafa.cream.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import java.time.ZonedDateTime;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Perference.
 */
@Entity
@Table(name = "perference")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "perference")
public class Perference implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "sujet", nullable = false)
    private String sujet;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "date_import", nullable = false)
    private ZonedDateTime dateImport;

    @NotNull
    @Lob
    @Column(name = "piece_jointe", nullable = false)
    private byte[] pieceJointe;

    @Column(name = "piece_jointe_content_type", nullable = false)        private String pieceJointeContentType;
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

    public ZonedDateTime getDateImport() {
        return dateImport;
    }

    public void setDateImport(ZonedDateTime dateImport) {
        this.dateImport = dateImport;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Perference perference = (Perference) o;
        return Objects.equals(id, perference.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Perference{" +
            "id=" + id +
            ", sujet='" + sujet + "'" +
            ", description='" + description + "'" +
            ", dateImport='" + dateImport + "'" +
            ", pieceJointe='" + pieceJointe + "'" +
            ", pieceJointeContentType='" + pieceJointeContentType + "'" +
            '}';
    }
}
