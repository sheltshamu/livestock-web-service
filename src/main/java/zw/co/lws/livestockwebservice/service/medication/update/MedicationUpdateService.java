package zw.co.lws.livestockwebservice.service.medication.update;

import zw.co.lws.livestockwebservice.service.medication.MedicationResponse;

@FunctionalInterface
public interface MedicationUpdateService {
    MedicationResponse update(MedicationUpdateRequest medicationUpdateRequest);
}
