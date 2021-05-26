package eci.edu.arsw.ecihorarios.services;

import eci.edu.arsw.ecihorarios.Exceptions.EciHorariosException;
import eci.edu.arsw.ecihorarios.model.Group;
import eci.edu.arsw.ecihorarios.model.Subject;
import eci.edu.arsw.ecihorarios.model.User;

import java.util.Set;

public interface UserServices {

    public User getUser(String email) throws EciHorariosException;

    void addUser(User user) throws EciHorariosException;

    User doLogin(User user) throws EciHorariosException;

    void addPreinscription(Set<Subject> preinscription, User user);

    void addPlan(Set<Group> preinscription, User user);

    void saveInscription(Set<Group> preinscription, User user);


}
