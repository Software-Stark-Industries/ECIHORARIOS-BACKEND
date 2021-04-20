package eci.edu.arsw.ecihorarios.persistence.impl;

import eci.edu.arsw.ecihorarios.Exceptions.EciHorariosException;
import eci.edu.arsw.ecihorarios.model.Group;
import eci.edu.arsw.ecihorarios.model.Subject;
import eci.edu.arsw.ecihorarios.persistence.SubjectPersistence;
import eci.edu.arsw.ecihorarios.persistence.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectPersistenceImpl implements SubjectPersistence {

    @Autowired
    SubjectRepository subjectRepository;
    @Override
    public Subject getSubject(String id) throws EciHorariosException {
        List<Subject> subjects = subjectRepository.getSubjectsById(id);
        if (subjects.isEmpty()) {
            throw new EciHorariosException("La materia con el id "+id+" no ha sido encontrada");
        }
        return subjects.get(0);
    }

    @Override
    public void addSubject(Subject subject) throws EciHorariosException {
        List<Subject> subjects = subjectRepository.getSubjectsById(subject.getId());
        if (!subjects.isEmpty()) {
            throw new EciHorariosException("La materia con el id " + subject + " ya se encuentra registrada");
        }
        subjectRepository.save(subject);
    }

    @Override
    public void addGroupToSubject(Group group, Subject subject) {
        subject.getGroups().add(group);
        subjectRepository.save(subject);
    }
}
