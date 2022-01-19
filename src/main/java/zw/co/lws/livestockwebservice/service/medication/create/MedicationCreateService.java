package zw.co.lws.livestockwebservice.service.medication.create;

import zw.co.lws.livestockwebservice.service.medication.MedicationResponse;

@FunctionalInterface
public interface MedicationCreateService {
    MedicationResponse create(MedicationCreateRequest medicationCreateRequest);
}
