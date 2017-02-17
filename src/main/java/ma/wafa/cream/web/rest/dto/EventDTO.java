package ma.wafa.cream.web.rest.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotNull;

/**
 * A DTO for the Action entity.
 */
public class EventDTO implements Serializable {

    private Long id;

    private String title;

    private LocalDate start;

    private LocalDate end;

    private String user;
    private String type;
   
    private String url;
    private String className;
    private Boolean stick =  true ; 
    private int delta =  0 ; 
   

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}



	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Boolean getStick() {
		return stick;
	}

	public void setStick(Boolean stick) {
		this.stick = stick;
	}

	public int getDelta() {
		return delta;
	}

	public void setDelta(int delta) {
		this.delta = delta;
	}

	@Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

	@Override
	public String toString() {
		return "EventDTO [id=" + id + ", title=" + title + ", start=" + start
				+ ", end=" + end + ", user=" + user + ", type=" + type + "]";
	}
}
