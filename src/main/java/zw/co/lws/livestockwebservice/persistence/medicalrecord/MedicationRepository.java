package zw.co.lws.livestockwebservice.persistence.medicalrecord;

import org.springframework.stereotype.Repository;
import zw.co.lws.livestockwebservice.domain.Medication;
import zw.co.lws.livestockwebservice.persistence.base.BaseRepository;

import java.util.List;

@Repository
public interface MedicationRepository extends BaseRepository<Medication> {
    List<Medication> findMedicationRecordsByAttendedBy(String name);
    List<Medication> findMedicationRecordsByTagNumber(String tagNumber);

}
