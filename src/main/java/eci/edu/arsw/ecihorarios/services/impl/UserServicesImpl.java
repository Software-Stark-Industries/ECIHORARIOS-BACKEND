package eci.edu.arsw.ecihorarios.services.impl;

import eci.edu.arsw.ecihorarios.Exceptions.EciHorariosException;
import eci.edu.arsw.ecihorarios.model.User;
import eci.edu.arsw.ecihorarios.persistence.impl.UserPersistenceImpl;
import eci.edu.arsw.ecihorarios.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    UserPersistenceImpl userPersistence;

    @Override
    public User getUser(String email) throws EciHorariosException {
        User user = userPersistence.getUser(email);
        return user;
    }

    @Override
    public void addUser(User user) throws EciHorariosException {
        userPersistence.addUser(user);
    }

    @Override
    public User doLogin(User user) throws EciHorariosException {
        return userPersistence.doLogin(user);
    }
}
