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
            System.out.println("***************************************************");
            System.out.println("***************************************************");
            System.out.println("***************************************************");
            subjectServices.addGroupToSubject(group,subjectServices.getSubject(id));
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (EciHorariosException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }
}