package zw.co.lws.livestockwebservice.service.medication.find;

import zw.co.lws.livestockwebservice.service.medication.MedicationResponse;

import java.util.List;

public interface FindMedicationService {
    MedicationResponse findById(Long id);
    List<MedicationResponse> findMedicationRecordsByTagNumber(String tagNumber);
}
