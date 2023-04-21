package com.adobe.exceptions;

public class PostException extends Exception{
    public PostException(){};
    public PostException(String message){
        super(message);
    }
}
