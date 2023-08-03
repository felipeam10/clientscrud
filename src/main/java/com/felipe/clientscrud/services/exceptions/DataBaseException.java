package com.felipe.clientscrud.services.exceptions;

public class DataBaseException extends RuntimeException { /*RuntimeException does not require a try catch*/

    public DataBaseException(String msg){
        super(msg);
    }


}
