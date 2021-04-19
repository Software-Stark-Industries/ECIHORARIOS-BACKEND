package eci.edu.arsw.ecihorarios.persistence;

import eci.edu.arsw.ecihorarios.Exceptions.EciHorariosException;
import eci.edu.arsw.ecihorarios.model.User;

public interface UserPersistence {

    public User getUser(String email) throws EciHorariosException;

    void addUser(User user) throws EciHorariosException;

    User doLogin(User user) throws EciHorariosException;
}
