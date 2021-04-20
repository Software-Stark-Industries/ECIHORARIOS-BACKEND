package eci.edu.arsw.ecihorarios.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "groups")
public class Group {

    @javax.persistence.Id
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "room", length = 200)
    private String room;

    @Column(name = "professor", length = 200)
    private String professor;

    @Column(name = "capacity", length = 50)
    private int capacity;

    @Column(name = "date_of_init", length = 200)
    private String hourOfInit;

    @Column(name = "date_of_end" , length = 200)
    private String hourOfEnd;

    @ManyToOne
    @JoinColumn(name = "subject")
    @JsonBackReference
    private Subject subject;

    public Group(){
    }

    public String getHourOfInit() {
        return hourOfInit;
    }

    public void setHourOfInit(String hourOfInit) {
        this.hourOfInit = hourOfInit;
    }

    public String getHourOfEnd() {
        return hourOfEnd;
    }

    public void setHourOfEnd(String hourOfEnd) {
        this.hourOfEnd = hourOfEnd;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

