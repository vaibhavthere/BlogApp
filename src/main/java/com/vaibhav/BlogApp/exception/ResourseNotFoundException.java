package com.vaibhav.BlogApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourseNotFoundException extends RuntimeException
{
    private String resourseName;
    private String fieldName;
    private String fieldValue;


    public ResourseNotFoundException(String resourseName, String fieldName, String fieldValue) {
        super(String.format("%s not found with %s : %s", resourseName, fieldName, fieldValue)); // PostEntity not found with id
        this.resourseName = resourseName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourseName() {
        return resourseName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }
}
