package zw.co.lws.livestockwebservice.service.medication.update;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MedicationUpdateRequest {
    private Long id;
    private String diseaseName;
    private String symptomsDescription;
    private String recommendedMedication;
    private String attendedBy;
    private LocalDateTime dateAttended;
    private String tagNumber;
}
