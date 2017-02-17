package ma.wafa.cream.web.rest.dto;

import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Lob;


/**
 * A DTO for the Perference entity.
 */
public class PerferenceDTO implements Serializable {

    private Long id;

    @NotNull
    private String sujet;

    private String description;

    @NotNull
    private ZonedDateTime dateImport;

    @NotNull
    @Lob
    private byte[] pieceJointe;

    private String pieceJointeContentType;

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

        PerferenceDTO perferenceDTO = (PerferenceDTO) o;

        if ( ! Objects.equals(id, perferenceDTO.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "PerferenceDTO{" +
            "id=" + id +
            ", sujet='" + sujet + "'" +
            ", description='" + description + "'" +
            ", dateImport='" + dateImport + "'" +
            ", pieceJointe='" + pieceJointe + "'" +
            '}';
    }
}
