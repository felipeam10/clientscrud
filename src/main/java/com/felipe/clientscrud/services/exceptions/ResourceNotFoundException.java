package com.felipe.clientscrud.services.exceptions;

public class ResourceNotFoundException extends RuntimeException { /*RuntimeException does not require a try catch*/

    public ResourceNotFoundException(String msg){
        super(msg);
    }


}
