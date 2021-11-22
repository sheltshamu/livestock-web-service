package zw.co.lws.livestockwebservice.service.cow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import zw.co.lws.livestockwebservice.domain.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CowRequest {
    private String tagNumber;
    private LocalDate dateOfBirth;
    private Type type;
    private Category category;
    private Gender gender;
    private String description;
    private Status status;
    private HealthStatus healthStatus;
    private Long motherId;
    private Long fatherId;
    private Long ownerId;
    private Long medicationRecordId;
}
