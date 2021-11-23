package zw.co.lws.livestockwebservice.service.medication;

import lombok.Getter;
import zw.co.lws.livestockwebservice.domain.MedicationRecord;

@Getter
public class MedicationResponse {
    private final MedicationRecord medicationRecord;

    public MedicationResponse(MedicationRecord medicationRecord) {
        this.medicationRecord = medicationRecord;
    }
}
