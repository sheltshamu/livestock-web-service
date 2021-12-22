package zw.co.lws.livestockwebservice.persistence.medicalrecord;

import org.springframework.stereotype.Repository;
import zw.co.lws.livestockwebservice.domain.MedicationRecord;
import zw.co.lws.livestockwebservice.persistence.base.BaseRepository;

import java.util.List;

@Repository
public interface MedicationRecordRepository extends BaseRepository<MedicationRecord> {
    List<MedicationRecord> findMedicationRecordsByAttendedBy(String name);
    List<MedicationRecord> findMedicationRecordsByTagNumber(String tagNumber);

}
