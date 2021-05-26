package eci.edu.arsw.ecihorarios.persistence.repositories;

import eci.edu.arsw.ecihorarios.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from users where email = :emailUser", nativeQuery = true)
    List<User> getUserByEmail(@Param("emailUser") String emailUser);

    @Query(value="SELECT carnet FROM users ORDER BY carnet desc limit 1", nativeQuery = true)
    String getLastCarnet();

}