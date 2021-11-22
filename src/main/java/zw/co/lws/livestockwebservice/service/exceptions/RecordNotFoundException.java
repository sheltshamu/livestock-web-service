package zw.co.lws.livestockwebservice.service.exceptions;

import java.text.MessageFormat;

public class RecordNotFoundException extends BusinessException{
    private Long id;
    public RecordNotFoundException(Long id) {
        super(MessageFormat.format("Record {0} not found",id));
    }
}
