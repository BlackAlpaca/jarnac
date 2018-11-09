package be.pxl.jarnac;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime localDateTime;

    private String necessities;

    private String location;

    private String title;

    private boolean isAdult;

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public void setNecessities(String necessities) {
        this.necessities = necessities;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getLocalDateTime() {
        return localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getNecessities() {
        return necessities;
    }

    public String getLocation() {
        return location;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAdult() {
        return isAdult;
    }
}