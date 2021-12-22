package zw.co.lws.livestockwebservice.service.medication;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MedicationRecordUpdateRequest {
    private Long id;
    private String diseaseName;
    private String symptomsDescription;
    private String recommendedMedication;
    private String attendedBy;
    private LocalDateTime dateAttended;
    private String tagNumber;
}
