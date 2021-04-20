package eci.edu.arsw.ecihorarios.persistence.repositories;

import eci.edu.arsw.ecihorarios.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {

    @Query(value = "select * from subjects where id = :idSubject", nativeQuery = true)
    List<Subject> getSubjectsById(@Param("idSubject") String idSubject);
}