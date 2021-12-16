package zw.co.lws.livestockwebservice.service.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionResponse {
    private String errorMessage;
    private String errorCode;
    private LocalDateTime timeStamp;

}
