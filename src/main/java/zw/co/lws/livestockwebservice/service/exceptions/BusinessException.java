package zw.co.lws.livestockwebservice.service.exceptions;

public abstract class BusinessException extends RuntimeException{
   private String message;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        this.message = message;
    }
}
