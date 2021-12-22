package zw.co.lws.livestockwebservice.service.medication;

import zw.co.lws.livestockwebservice.domain.MedicationRecord;

import java.util.List;

public interface MedicationRecordService {
    MedicationResponse create(MedicationRecordRequest medicationRecordRequest);
    MedicationResponse update(MedicationRecordUpdateRequest medicationRecordUpdateRequest);
    MedicationResponse findById(Long id);
    List<MedicationResponse> findMedicationRecordsByTagNumber(String tagNumber);
}
