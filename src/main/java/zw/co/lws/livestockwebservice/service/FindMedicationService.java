package zw.co.lws.livestockwebservice.service;

import java.util.List;

public interface FindMedicationService {
    MedicationResponse findById(Long id);
    List<MedicationResponse> findMedicationRecordsByTagNumber(String tagNumber);
}
