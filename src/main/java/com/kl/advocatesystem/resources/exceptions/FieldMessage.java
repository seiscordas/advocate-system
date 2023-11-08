package com.kl.advocatesystem.resources.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class FieldMessage implements Serializable {
    private String fieldName;
    private String message;

    public FieldMessage(){}

    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }
}
