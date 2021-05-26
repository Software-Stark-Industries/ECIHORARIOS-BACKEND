package eci.edu.arsw.ecihorarios.controllers;

import eci.edu.arsw.ecihorarios.Exceptions.EciHorariosException;
import eci.edu.arsw.ecihorarios.model.User;
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
@RequestMapping(value = "/api/v1/users")
public class UserController {

    @Autowired
    private UserServices userServices;


    /**
     * Obtiene un usuario por el email
     * @param email el email del usuario
     * @return el usuario correspondiente a ese email y el codigo http correspondiente
     */
    @GetMapping(value = "{email}")
    public ResponseEntity<?> getUser(@PathVariable String email) {
        try {
            User user = userServices.getUser(email);
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        } catch (EciHorariosException e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Añade un usuario a la aplicacion EciHorarios
     * @param user usuario a ser añadido
     * @return un codigo http de respuesta que indica el resultado de la operacion
     */
    @PostMapping(value = "")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        System.out.println("\n ENTRA EN GUARDAR USUARIIO: "+user+"\n");
        if (user.getEmail() == null)
            return new ResponseEntity<>("Bad format", HttpStatus.BAD_REQUEST);
        try {
            userServices.addUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (EciHorariosException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }

}