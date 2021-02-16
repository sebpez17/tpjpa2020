package jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class Meeting {
    private long id;
    private Instant dateStart;
    private String clearCode;
    private String resourceUri;

    public Meeting() {
    }

    public Meeting(Instant dateStart, String clearCode, String resourceUri) {
        this.dateStart = dateStart;
        this.clearCode = clearCode;
        this.resourceUri = resourceUri;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Instant getDateStart() {
        return dateStart;
    }

    public void setDateStart(Instant dateStart) {
        this.dateStart = dateStart;
    }

    public String getClearCode() {
        return clearCode;
    }

    public void setClearCode(String clearCode) {
        this.clearCode = clearCode;
    }

    public String getResourceUri() {
        return resourceUri;
    }

    public void setResourceUri(String resourceUri) {
        this.resourceUri = resourceUri;
    }

    @Override
    public String toString() {
        return String.format("Meeting [id=%d, dateStart=%s, clearCode=%s, resourceUri=%s]",
                this.id, this.dateStart.toString(), this.clearCode, this.resourceUri);
    }
}
