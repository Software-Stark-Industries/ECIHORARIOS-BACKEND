package eci.edu.arsw.ecihorarios.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @javax.persistence.Id
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "email", length = 200, unique = true)
    private String email;

    @Column(name = "password", length = 200, unique = true)
    private String password;

    @Column(name = "is_admin", length = 200, unique = true)
    private boolean isAdmin;

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

}

