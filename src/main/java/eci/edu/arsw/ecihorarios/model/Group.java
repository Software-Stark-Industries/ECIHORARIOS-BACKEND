package eci.edu.arsw.ecihorarios.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {



    @Column(name = "capacity", length = 50)
    private int capacity;

    //@ElementCollection(targetClass=String.class)
    @Column(name = "horario_dia")
    private ArrayList<String> dias;

    //Esto lo agregue yo
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "group_id", length=3)
    private int gruoupId;


    @Column(name = "date_of_end" , length = 200)
    private String hourOfEnd;

    @Column(name = "date_of_init", length = 200)
    private String hourOfInit;

    @Column(name = "professor", length = 200)
    private String professor;

    @Column(name = "room", length = 200)
    private String room;

    @ManyToOne
    @JoinColumn(name = "subject")
    @JsonBackReference
    private Subject subject;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;


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

    public int getGruoupId() {
        return gruoupId;
    }

    public void setGruoupId(int gruoupId) {
        this.gruoupId = gruoupId;
    }

    public ArrayList<String> getDias() {
        return dias;
    }

    public void setDias(ArrayList<String> dias) {
        this.dias = dias;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", room='" + room + '\'' +
                ", professor='" + professor + '\'' +
                ", capacity=" + capacity +
                ", hourOfInit='" + hourOfInit + '\'' +
                ", hourOfEnd='" + hourOfEnd + '\'' +
                ", gruoupId=" + gruoupId +
                ", subject=" + subject +
                ", dias=" + dias +
                '}';
    }
}

