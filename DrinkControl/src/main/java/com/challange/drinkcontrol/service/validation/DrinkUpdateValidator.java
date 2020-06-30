package com.challange.drinkcontrol.service.validation;

import com.challange.drinkcontrol.domain.Session;
import com.challange.drinkcontrol.dto.DrinkDTO;
import com.challange.drinkcontrol.resource.exception.FieldMessage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class DrinkUpdateValidator implements ConstraintValidator<DrinkUpdate, DrinkDTO> {

    @Override
    public void initialize(DrinkUpdate drinkInsert) {
    }

    @Override
    public boolean isValid(DrinkDTO drinkDTO, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

//        if ("".equals(sessionDTO.getSessionDescription())){
//            list.add(new FieldMessage("sessionDescription", "Description invalid"));
//        }

//        Session existSession = sessionRepository.findBySessionDescription(sessionDTO.getSessionDescription());

//        if(existSession != null){
//            list.add(new FieldMessage("sessionDescription", "This description already exists"));
//        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getField()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
