package com.challange.drinkcontrol.service;

import com.challange.drinkcontrol.domain.Session;
import com.challange.drinkcontrol.dto.SessionDTO;
import com.challange.drinkcontrol.repository.SessionRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public Session find(Integer id) {
        Optional<Session> session = sessionRepository.findById(id);

        return session.orElseThrow(() -> new ObjectNotFoundException("Session not found :Id" + id,
                "Type: " + Session.class.getName()));
    }

    public Page<Session> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction.toUpperCase()), orderBy);
        return sessionRepository.findAll(pageRequest);
    }

    public Session fromDTO(SessionDTO sessionDTO) {
        return new Session(sessionDTO.getId(), sessionDTO.getSessionDescription());
    }

    public Session insert(Session session) {
        return sessionRepository.save(session);
    }

    public void update(Session session) {
        sessionRepository.save(session);
    }

    public void delete(Integer id) {
        try {
            sessionRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("It's not possible delete a session that has drink");
        }
    }
}
