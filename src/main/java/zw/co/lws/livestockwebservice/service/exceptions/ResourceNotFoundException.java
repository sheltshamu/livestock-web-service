package zw.co.lws.livestockwebservice.service.exceptions;

import java.text.MessageFormat;

public class ResourceNotFoundException extends RuntimeException{
    private Long id;
    private String value;
    
    public ResourceNotFoundException(String message) {
        super(message);
    }
    public ResourceNotFoundException(String message,Long id){
        super(MessageFormat.format(message,id));
        this.id=id;
    }

    public ResourceNotFoundException(String message, String value){
        super(MessageFormat.format(message,value));
        this.value=value;
    }
}
