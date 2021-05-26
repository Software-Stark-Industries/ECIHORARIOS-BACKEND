package eci.edu.arsw.ecihorarios.persistence;


import eci.edu.arsw.ecihorarios.Exceptions.EciHorariosException;
import eci.edu.arsw.ecihorarios.model.Subject;

public interface PreschedulePersistence {

    Subject getPreschedule(String id) throws EciHorariosException;

    void addSubject(Subject subject) throws EciHorariosException;

}
