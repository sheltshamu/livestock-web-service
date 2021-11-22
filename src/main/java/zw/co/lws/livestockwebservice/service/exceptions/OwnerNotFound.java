package zw.co.lws.livestockwebservice.service.exceptions;

import java.text.MessageFormat;

public class OwnerNotFound extends BusinessException{
    private Long ownerId;

    public OwnerNotFound(Long ownerId){
        super(MessageFormat.format("Owner {0} Not Found",ownerId));
    }
}
