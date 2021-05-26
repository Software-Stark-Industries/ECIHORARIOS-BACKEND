package eci.edu.arsw.ecihorarios.persistence;

import eci.edu.arsw.ecihorarios.Exceptions.EciHorariosException;
import eci.edu.arsw.ecihorarios.model.Group;
import eci.edu.arsw.ecihorarios.model.Subject;
import eci.edu.arsw.ecihorarios.model.User;

import java.util.List;
import java.util.Set;

public interface UserPersistence {

    public User getUser(String email) throws EciHorariosException;

    void addUser(User user) throws EciHorariosException;

    List<User> getUsers() throws EciHorariosException;

    String getLastCarnet() throws EciHorariosException;

    User doLogin(User user) throws EciHorariosException;

    void addPreinscription(Set<Subject> preinscripcion, User user);

    void addPlan(Set<Group> preinscripcion, User user);

    void saveInscription(Set<Group> preinscripcion, User user);
}
