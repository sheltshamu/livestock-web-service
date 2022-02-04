package zw.co.lws.livestockwebservice.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zw.co.lws.livestockwebservice.domain.enums.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CowUpdateRequest {
    private String tagNumber;
    private LocalDate dateOfBirth;
    private Breed breed;
    private Category category;
    private Gender gender;
    private String description;
    private Status status;
    private HealthStatus healthStatus;
    private Long motherId;
    private Long fatherId;
    private Long ownerId;
}
