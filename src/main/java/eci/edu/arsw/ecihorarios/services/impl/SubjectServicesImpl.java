package eci.edu.arsw.ecihorarios.services.impl;

import eci.edu.arsw.ecihorarios.Exceptions.EciHorariosException;
import eci.edu.arsw.ecihorarios.model.Group;
import eci.edu.arsw.ecihorarios.model.Subject;
import eci.edu.arsw.ecihorarios.persistence.impl.SubjectPersistenceImpl;
import eci.edu.arsw.ecihorarios.services.SubjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServicesImpl implements SubjectServices {

    @Autowired
    SubjectPersistenceImpl subjectPersistence;
    @Override
    public Subject getSubject(String id) throws EciHorariosException {
        return subjectPersistence.getSubject(id);
    }

    @Override
    public void addSubject(Subject subject) throws EciHorariosException {
        subjectPersistence.addSubject(subject);
    }

    @Override
    public void addGroupToSubject(Group group, Subject subject) {
        subjectPersistence.addGroupToSubject(group,subject);
    }
}
