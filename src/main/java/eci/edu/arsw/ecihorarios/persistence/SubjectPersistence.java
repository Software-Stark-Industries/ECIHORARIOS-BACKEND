package eci.edu.arsw.ecihorarios.persistence;

import eci.edu.arsw.ecihorarios.Exceptions.EciHorariosException;
import eci.edu.arsw.ecihorarios.model.Group;
import eci.edu.arsw.ecihorarios.model.Subject;
import eci.edu.arsw.ecihorarios.model.User;

import java.util.Set;

public interface SubjectPersistence {

    Subject getSubject(String id) throws EciHorariosException;

    void addSubject(Subject subject) throws EciHorariosException;

    void addGroupToSubject(Group group, Subject subject);

}
