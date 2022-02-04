package zw.co.lws.livestockwebservice.service;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MedicationCreateRequest {
    private String diseaseName;
    private String symptomsDescription;
    private String recommendedMedication;
    private String attendedBy;
    private LocalDateTime dateAttended;
    private String tagNumber;
}

