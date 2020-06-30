package com.challange.drinkcontrol.resource.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends DefaultError {

    private List<FieldMessage> fieldErrorList = new ArrayList<>();

    public ValidationError(Integer status, String msg) {
        super(status, msg);
    }

    public List<FieldMessage> getErrors() {
        return fieldErrorList;
    }

    public void addError(String fieldName, String filedMessage) {
        fieldErrorList.add(new FieldMessage(fieldName, filedMessage));
    }
}
