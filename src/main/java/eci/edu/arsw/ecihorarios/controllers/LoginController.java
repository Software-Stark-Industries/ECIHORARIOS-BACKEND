package eci.edu.arsw.ecihorarios.controllers;

import eci.edu.arsw.ecihorarios.Exceptions.EciHorariosException;
import eci.edu.arsw.ecihorarios.model.Token;
import eci.edu.arsw.ecihorarios.model.User;
import eci.edu.arsw.ecihorarios.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.jasypt.util.password.PasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;


/**
 * Controlador API Rest de la aplicación ECI-HORARIOS
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private PasswordEncryptor passwordEncryptor;

    @PostMapping(value = "/hola")
    public ResponseEntity<?> doLogin(@RequestBody User user) {
        System.out.println("Entrando por login antiguo: "+user);
        try {
            User dbUser = userServices.doLogin(user);
            return new ResponseEntity<>(dbUser , HttpStatus.ACCEPTED);
        } catch (EciHorariosException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value="/",method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody User user) throws ServletException, EciHorariosException {
        String jwtToken = "";
        System.out.println("\n Entrando en login! "+ user);
        if (user.getEmail() == null || user.getPassword()== null) {
            throw new ServletException("Please fill in username and password");
        }

        String email = user.getEmail();
        String password = user.getPassword();

        User _user = userServices.getUser(email);

        String pwd = _user.getPassword();

        if (!passwordEncryptor.checkPassword(password, pwd)) {
            System.out.println("SON DIFERENTES LAS CONTRASEÑAS!!!: "+password+" & " +pwd);
            throw new ServletException("Invalid login. Please check your name and password.");
        }

        jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date()).signWith(
                SignatureAlgorithm.HS256, "secretkey").compact();
        System.out.println("\n Jwt TOken: "+jwtToken);
        System.out.println("\n _user: "+_user+"\n");
        return new ResponseEntity<>(new Token(jwtToken, _user), HttpStatus.OK);
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ResponseEntity<Object> saveUser(@RequestBody User user) {
        try {
            System.out.println("VA A GUARDAR NUEVO USUARIO: "+user);
            System.out.println("VA A GUARDAR NUEVO USUARIO PASS: "+user.getPassword());
            userServices.addUser(user);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error 404", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("USER_CREATED", HttpStatus.CREATED);
    }

}