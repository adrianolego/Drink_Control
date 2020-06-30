package com.challange.drinkcontrol.service.validation;

import com.challange.drinkcontrol.domain.DrinkType;
import com.challange.drinkcontrol.domain.Session;
import com.challange.drinkcontrol.dto.BatchDrinkDTO;
import com.challange.drinkcontrol.resource.exception.FieldMessage;
import com.challange.drinkcontrol.service.DrinkTypeService;
import com.challange.drinkcontrol.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class BatchDrinkUpdateValidator implements ConstraintValidator<BatchDrinkUpdate, BatchDrinkDTO> {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private DrinkTypeService drinkTypeService;

    @Override
    public void initialize(BatchDrinkUpdate drinkInsert) {
    }

    @Override
    public boolean isValid(BatchDrinkDTO batchDrinkDTO, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if (batchDrinkDTO.getAmount() >= 0){
            list.add(new FieldMessage("amount", "Amount invalid"));
        }
        Session session = sessionService.find(batchDrinkDTO.getIdSession());
        DrinkType drinkType = drinkTypeService.find(batchDrinkDTO.getIdDrinkType());

        if(session == null){
            list.add(new FieldMessage("idSession", "This value non exists"));
        }

        if(drinkType == null){
            list.add(new FieldMessage("idDrinkType", "This description already exists"));
        }

        if("".equals(batchDrinkDTO.getResponsiblePerson())){
            list.add(new FieldMessage("responsiblePerson", "This value must be filled "));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getField()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
