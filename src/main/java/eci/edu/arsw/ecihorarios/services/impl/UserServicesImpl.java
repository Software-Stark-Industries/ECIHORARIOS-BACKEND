package eci.edu.arsw.ecihorarios.services.impl;

import eci.edu.arsw.ecihorarios.Exceptions.EciHorariosException;
import eci.edu.arsw.ecihorarios.model.Group;
import eci.edu.arsw.ecihorarios.model.Subject;
import eci.edu.arsw.ecihorarios.model.User;
import eci.edu.arsw.ecihorarios.persistence.impl.UserPersistenceImpl;
import eci.edu.arsw.ecihorarios.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.jasypt.util.password.PasswordEncryptor;
import java.util.List;
import java.util.Set;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    UserPersistenceImpl userPersistence;

    @Autowired
    private PasswordEncryptor passwordEncryptor;

    @Override
    public User getUser(String email) throws EciHorariosException {
        User user = userPersistence.getUser(email);
        return user;
    }

    @Override
    public void addUser(User user) throws EciHorariosException {
        user.setPassword(passwordEncryptor.encryptPassword(user.getPassword()));
        user.setCreditos(18);
        user.setAdmin(false);
        String lastCarnet = userPersistence.getLastCarnet();
        System.out.println("LAST CARNET: "+lastCarnet);
        if(lastCarnet==null){
            lastCarnet = "2145671";
        }
        Integer newCarnet = Integer.parseInt(lastCarnet)+1;
        user.setCarnet(newCarnet+"");
        userPersistence.addUser(user);
    }


    public List<User> getUsers() throws EciHorariosException {
        List<User> users =  userPersistence.getUsers();
        System.out.println("\n TODOS LOS USUARIOS: "+users+"\n");
        return users;
    }




    private void carnetAsignation(User user){

    }

    @Override
    public User doLogin(User user) throws EciHorariosException {
        return userPersistence.doLogin(user);
    }

    @Override
    public void addPreinscription(Set<Subject> preinscription, User user) {
        userPersistence.addPreinscription(preinscription,user);
    }

    @Override
    public void addPlan(Set<Group> preinscription, User user) {
        userPersistence.addPlan(preinscription,user);
    }

    @Override
    public void saveInscription(Set<Group> preinscription, User user) {
        userPersistence.saveInscription(preinscription,user);
    }


}
