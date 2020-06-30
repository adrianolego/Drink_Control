package com.challange.drinkcontrol.service.validation;

import com.challange.drinkcontrol.dto.BatchDrinkDTO;
import com.challange.drinkcontrol.resource.exception.FieldMessage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class BatchDrinkUpdateValidator implements ConstraintValidator<BatchDrinkUpdate, BatchDrinkDTO> {

    @Override
    public void initialize(BatchDrinkUpdate drinkInsert) {
    }

    @Override
    public boolean isValid(BatchDrinkDTO batchDrinkDTO, ConstraintValidatorContext context) {
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
