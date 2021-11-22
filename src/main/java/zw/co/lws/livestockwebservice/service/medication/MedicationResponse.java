package zw.co.lws.livestockwebservice.service.medication;

import zw.co.lws.livestockwebservice.domain.MedicationRecord;

public class MedicationResponse {
    private final MedicationRecord medicationRecord;

    public MedicationResponse(MedicationRecord medicationRecord) {
        this.medicationRecord = medicationRecord;
    }
}
