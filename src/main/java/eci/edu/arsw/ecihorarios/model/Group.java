package eci.edu.arsw.ecihorarios.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.security.Timestamp;

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

    @Column(name = "professor", length = 200, unique = true)
    private String professor;

    @Column(name = "capacity", length = 50, nullable = false)
    private int capacity;

    @Column(name = "date_of_init", length = 200, unique = true)
    private String dateOfInit;

    @Column(name = "date_of_end" , length = 200, unique = true)
    private String dateOfEnd;

    @ManyToOne
    @JoinColumn(name = "subject")
    @JsonBackReference
    private Subject subject;

    public Group(){
    }

    public Group(long id, String room, String professor, int capacity, Timestamp dateOfInit, Timestamp dateOfEnd) {
        this.id = id;
        this.room = room;
        this.professor = professor;
        this.capacity = capacity;
        this.dateOfInit = dateOfInit;
        this.dateOfEnd = dateOfEnd;
    }

    public Timestamp getDateOfInit() {
        return dateOfInit;
    }

    public void setDateOfInit(Timestamp dateOfInit) {
        this.dateOfInit = dateOfInit;
    }

    public Timestamp getDateOfEnd() {
        return dateOfEnd;
    }

    public void setDateOfEnd(Timestamp dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
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

