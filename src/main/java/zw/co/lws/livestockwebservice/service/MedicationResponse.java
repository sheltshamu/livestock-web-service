package zw.co.lws.livestockwebservice.service;

import lombok.Getter;
import zw.co.lws.livestockwebservice.domain.Medication;

@Getter
public class MedicationResponse {
    private final Medication medication;

    public MedicationResponse(Medication medication) {
        this.medication = medication;
    }
}
