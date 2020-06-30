package com.challange.drinkcontrol.service.validation;

import com.challange.drinkcontrol.domain.Session;
import com.challange.drinkcontrol.dto.SessionDTO;
import com.challange.drinkcontrol.repository.SessionRepository;
import com.challange.drinkcontrol.resource.exception.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class SessionUpdateValidator implements ConstraintValidator<SessionUpdate, SessionDTO> {

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public void initialize(SessionUpdate clienteInsert) {
    }

    @Override
    public boolean isValid(SessionDTO sessionDTO, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if ("".equals(sessionDTO.getSessionDescription())){
            list.add(new FieldMessage("sessionDescription", "Description invalid"));
        }

        Session existSession = sessionRepository.findBySessionDescription(sessionDTO.getSessionDescription());

        if(existSession != null){
            list.add(new FieldMessage("sessionDescription", "This description already exists"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getField()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
