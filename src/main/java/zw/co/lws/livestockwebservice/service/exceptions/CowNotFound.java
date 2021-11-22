package zw.co.lws.livestockwebservice.service.exceptions;

import java.text.MessageFormat;

public class CowNotFound extends BusinessException{
    private String tagNumber;
    
    public CowNotFound(String tagNumber){
        super(MessageFormat.format("Cow with tag number {0} not found",tagNumber));
    }
}
