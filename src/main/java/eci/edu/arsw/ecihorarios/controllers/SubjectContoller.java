package eci.edu.arsw.ecihorarios.controllers;

import eci.edu.arsw.ecihorarios.Exceptions.EciHorariosException;
import eci.edu.arsw.ecihorarios.model.Group;
import eci.edu.arsw.ecihorarios.model.Subject;
import eci.edu.arsw.ecihorarios.model.User;
import eci.edu.arsw.ecihorarios.services.SubjectServices;
import eci.edu.arsw.ecihorarios.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Controlador API Rest de la aplicación ECI-HORARIOS
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/v1/subjects")
public class SubjectContoller {

    @Autowired
    private SubjectServices subjectServices;

    @Autowired
    private UserServices userServices;


    @GetMapping(value = "{id}")
    public ResponseEntity<?> getSubject(@PathVariable String id) {
        try {
            Subject subject = subjectServices.getSubject(id);
            System.out.println("\n Retornando subject: "+subject+"\n");
            return new ResponseEntity<>(subject, HttpStatus.ACCEPTED);
        } catch (EciHorariosException e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "")
    public ResponseEntity<?> addSubject(@RequestBody Subject subject) {
        try {
            subjectServices.addSubject(subject);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (EciHorariosException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping(value = "{id}")
    public ResponseEntity<?> addGroupToSubject(@PathVariable String id ,@RequestBody Group group) {
        try {
            System.out.println("\n Group: "+group+"\n");
<<<<<<< HEAD
=======
            System.out.println("***************************************************");
            System.out.println("***************************************************");
            System.out.println("***************************************************");
>>>>>>> 624e96d703f4684bf4aa3f2b35fc78dbeba4859c
            subjectServices.addGroupToSubject(group,subjectServices.getSubject(id));
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (EciHorariosException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping(value="/preinscription/{user}")
    public ResponseEntity<?>savePreinscription(@RequestBody Set<Subject> subjects, @PathVariable("user")String user){
        try {
            User usuario = userServices.getUser(user);
            //Mirar si cambiamos a List o dejamos Set la preinscripción
            System.out.println("\n Materias preinscritas: "+subjects+"\n");
            userServices.addPreinscription(subjects,usuario);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EciHorariosException e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value="/plan/{user}")
    public ResponseEntity<?>savePlanPreinscription(@RequestBody Set<Group> subjects, @PathVariable("user")String user){
        try {
            User usuario = userServices.getUser(user);
            //Mirar si cambiamos a List o dejamos Set la preinscripción
            System.out.println("\n PLAN Materias preinscritas: "+subjects+"\n");
            userServices.addPlan(subjects,usuario);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EciHorariosException e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping(value="/inscription/{user}")
    public ResponseEntity<?>saveInscription(@RequestBody Set<Group> subjects, @PathVariable("user")String user){
        try {
            User usuario = userServices.getUser(user);
            //Mirar si cambiamos a List o dejamos Set la preinscripción
            System.out.println("\n PLAN Materias A inscribir: "+subjects+"\n");
            userServices.saveInscription(subjects,usuario);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EciHorariosException e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }




    @GetMapping(value="/preinscription/{id}")
    public ResponseEntity<?>getPreinscriptionUser(@PathVariable String id){
        try {
            System.out.println("EL ID DEL USUARIO BUSCADO ES: "+id);
            //Subject subject = subjectServices.getSubject(id);
            User user = userServices.getUser(id);
            System.out.println("\n Retornando user: "+user+"\n");
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (EciHorariosException e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}