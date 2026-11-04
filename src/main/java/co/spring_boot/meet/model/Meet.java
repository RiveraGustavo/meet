package co.spring_boot.meet.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;

@Entity 
@Table(name = "reunion")
public class Meet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "asunto")
    private String name;
    @Column(name = "fecha")
    private Date date;
    
    @ManyToMany
    @JoinTable(
        name = "asistente",
        joinColumns = {@JoinColumn(name = "reunion_id")},
        inverseJoinColumns = {@JoinColumn(name = "persona_id")}
    )
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
    public String toString() {
        return "[id=" + id + ", name=" + name + ", date=" + date;
    }
}
