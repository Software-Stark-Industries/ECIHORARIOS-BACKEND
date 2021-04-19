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
@RequestMapping(value = "/api/v1/login")
public class LoginController {

    @Autowired
    private UserServices userServices;


    @PostMapping(value = "")
    public ResponseEntity<?> doLogin(@RequestBody User user) {
        try {
            User dbUser = userServices.doLogin(user);
            return new ResponseEntity<>(dbUser , HttpStatus.ACCEPTED);
        } catch (EciHorariosException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

}