package eci.edu.arsw.ecihorarios.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
//@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "email", length = 200, unique = true)
    private String email;

    @Column(name = "password", length = 200)
    private String password;

    @Column(name = "is_admin", length = 200)
    private boolean isAdmin;

    @Column(name = "carnet", length = 200, unique = true)
    private String carnet;

    @Column(name = "creditos")
    private int creditos;

    @OneToMany
    @JoinColumn(name = "preinscription")
    @JsonManagedReference
    private Set<Subject> preinscription;

    //@OneToMany
    //@JoinColumn(name = "inscription")
    //private Set<Group> inscription;

    /*
    @OneToMany
    @JoinColumn(name = "plan")
    @JsonManagedReference
    private Set<SetGroup> plans;
*/

    public User() {
    }

    public User(long id, String name, String email, String password, boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Set<Subject> getPreinscription() {
        return preinscription;
    }

    public void setPreinscription(Set<Subject> preinscription) {
        this.preinscription = preinscription;
    }
/*
    public Set<Group> getPlans() {
        return plans;
    }

    public void setPlans(Set<Group> plans) {
        this.plans = plans;
    }
*/
/*
    public Set<Group> getInscription() {
        return inscription;
    }

    public void setInscription(Set<Group> inscription) {
        this.inscription = inscription;
    }
*/
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", carnet='" + carnet + '\'' +
                ", creditos=" + creditos +
                ", preinscription=" + preinscription +
                '}';
    }
}

