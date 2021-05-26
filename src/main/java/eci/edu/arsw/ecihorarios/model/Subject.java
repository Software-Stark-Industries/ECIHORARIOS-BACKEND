package eci.edu.arsw.ecihorarios.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "Subject")
@Table(name = "subjects")
public class Subject implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name", length = 255, nullable = false)
    private String nombre;

    @Column(name = "description", length = 255, unique = true, nullable = false)
    private String description;

    @Column(name = "program", length = 255, nullable = false)
    private String program;

    @Column(name = "credits", nullable = false)
    private int credits;
    

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "groups")
    @JsonManagedReference
    private List<Group> groups;


    @ManyToOne
    @JoinColumn(name = "student")
    @JsonBackReference
    private User student;



    public Subject(String id, String nombre, String description, String program, int credits) {
        this.id = id;
        this.nombre = nombre;
        this.description = description;
        this.program = program;
        this.credits = credits;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Subject() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


    @Override
    public String toString() {
        return super.toString();
    }


}