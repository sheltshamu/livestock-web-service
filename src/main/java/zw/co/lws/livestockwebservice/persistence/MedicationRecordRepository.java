package zw.co.lws.livestockwebservice.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import zw.co.lws.livestockwebservice.domain.MedicationRecord;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicationRecordRepository extends BaseRepository<MedicationRecord>{
    List<MedicationRecord> findMedicationRecordsByAttendedBy(String name);
    //List<MedicationRecord> findMedicationRecordsByCow

}
