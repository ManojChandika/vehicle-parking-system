package com.example.vehiclemanagementsystem.exception;

public class ResourceNotFoundException extends RuntimeException{
    public String resourceName;
    public String fieldName;
    public Long fieldValue;

    public ResourceNotFoundException( String resourceName, String fieldName, Long fieldValue) {
        super(String.format("%s not found with %s : %s ",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResource() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Long getFieldValue() {
        return fieldValue;
    }
}
