package zw.co.lws.livestockwebservice.service;

@FunctionalInterface
public interface MedicationUpdateService {
    MedicationResponse update(MedicationUpdateRequest medicationUpdateRequest);
}
