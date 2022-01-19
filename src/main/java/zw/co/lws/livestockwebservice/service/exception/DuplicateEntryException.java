package zw.co.lws.livestockwebservice.service.exception;

import java.text.MessageFormat;

public class DuplicateEntryException extends RuntimeException{
    private String value;

    public DuplicateEntryException(String message) {
        super(message);
    }

    public DuplicateEntryException(String message, String value) {
        super(MessageFormat.format(message,value));
        this.value=value;
    }
}
