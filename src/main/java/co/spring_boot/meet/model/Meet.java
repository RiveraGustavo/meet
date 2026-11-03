package co.spring_boot.meet.model;

import java.util.Date;
import java.util.List;

public class Meet {
    private long id;
    private String name;
    private Date date;
    private List<Persona> participants;
    
    public Meet() {
    }

    public Meet(long id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.participants = new java.util.ArrayList<>();
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public List<Persona> getParticipants() {
        return participants;
    }
    public void setParticipants(List<Persona> participants) {
        this.participants = participants;
    }
    public void addParticipant(Persona participant) {
        this.participants.add(participant);
    }

}
