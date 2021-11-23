package zw.co.lws.livestockwebservice.service.medication;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author sheltons
 * created at 23-Nov-2021 16:19
 */
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
