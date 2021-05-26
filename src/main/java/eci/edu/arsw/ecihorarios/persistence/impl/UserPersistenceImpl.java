package eci.edu.arsw.ecihorarios.persistence.impl;

import eci.edu.arsw.ecihorarios.Exceptions.EciHorariosException;
import eci.edu.arsw.ecihorarios.model.Group;
import eci.edu.arsw.ecihorarios.model.Subject;
import eci.edu.arsw.ecihorarios.model.User;
import eci.edu.arsw.ecihorarios.persistence.UserPersistence;
import eci.edu.arsw.ecihorarios.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

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
    public List<User> getUsers() throws EciHorariosException {
        return userRepository.findAll();
    }

    @Override
    public String getLastCarnet() {
        System.out.println("\n Fue a buscar a la base de datos el ultimo carnet \n");
        return userRepository.getLastCarnet();
    }

    @Override
    public User doLogin(User user) throws EciHorariosException {
        User dbUser = getUser(user.getEmail());
        if(!dbUser.getPassword().equals(user.getPassword())){
            throw new EciHorariosException("Credenciales incorrectas");
        }
        return dbUser;
    }


    @Override
    public void addPreinscription(Set<Subject> preinscripcion, User user) {
        System.out.println("Va a agregar grupo al subject: "+user.getId()+" y "+ user.getName());
        //user.getPreinscription().add(preinscripcion);
        user.getPreinscription().addAll(preinscripcion);
        System.out.println("\n "+user.getPreinscription().toString() +"\n");
        userRepository.save(user);
    }

    @Override
    public void addPlan(Set<Group> preinscripcion, User user) {
        System.out.println("*************************************************");
        System.out.println("ADD PLAN");
        System.out.println("Va a agregar grupo al subject: "+user.getId()+" y "+ user.getName());
        System.out.println("*************************************************");
        //user.getPreinscription().add(preinscripcion);
        //user.getPlans().addAll(preinscripcion);
        //System.out.println("\n "+user.getPreinscription().toString() +"\n");
        userRepository.save(user);
    }

    @Override
    public void saveInscription(Set<Group> preinscripcion, User user) {
        System.out.println("*************************************************");
        System.out.println("SAVE INSCRIPTION");
        System.out.println("Va a agregar grupo al subject: "+user.getId()+" y "+ user.getName());
        System.out.println("*************************************************");
        //user.getPreinscription().add(preinscripcion);
        //user.getPlans().addAll(preinscripcion);
        //System.out.println("\n "+user.getPreinscription().toString() +"\n");
        userRepository.save(user);
    }
}
