package zw.co.lws.livestockwebservice.service;

@FunctionalInterface
public interface MedicationCreateService {
    MedicationResponse create(MedicationCreateRequest medicationCreateRequest);
}
