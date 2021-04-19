package eci.edu.arsw.ecihorarios.persistence.impl;

import eci.edu.arsw.ecihorarios.Exceptions.EciHorariosException;
import eci.edu.arsw.ecihorarios.model.User;
import eci.edu.arsw.ecihorarios.persistence.UserPersistence;
import eci.edu.arsw.ecihorarios.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPersistenceImpl implements UserPersistence {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUser(String email) throws EciHorariosException {
        List<User> users = userRepository.getUserByEmail(email);
        if (users.isEmpty()) {
            throw new EciHorariosException("El usuario con email "+email+" no ha sido encontrado");
        }
        return users.get(0);
    }

    @Override
    public void addUser(User user) throws EciHorariosException {
        List<User> users = userRepository.getUserByEmail(user.getEmail());
        if (!users.isEmpty()) {
            throw new EciHorariosException("El usuario con el email "+user.getEmail()+" ya se encuentra registrado");
        }
        userRepository.save(user);
        getUser(user.getEmail()).setId(getUser(user.getEmail()).getId());
    }

    @Override
    public User doLogin(User user) throws EciHorariosException {
        User dbUser = getUser(user.getEmail());
        if(!dbUser.getPassword().equals(user.getPassword())){
            throw new EciHorariosException("Credenciales incorrectas");
        }
        return dbUser;
    }
}
