package eci.edu.arsw.ecihorarios.services;

import eci.edu.arsw.ecihorarios.Exceptions.EciHorariosException;
import eci.edu.arsw.ecihorarios.model.Group;
import eci.edu.arsw.ecihorarios.model.Subject;

public interface SubjectServices {

    Subject getSubject(String id) throws EciHorariosException;

    void addSubject(Subject subject) throws EciHorariosException;

    void addGroupToSubject(Group group, Subject subject);
}
