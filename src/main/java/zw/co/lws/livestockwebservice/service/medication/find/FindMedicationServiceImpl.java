package zw.co.lws.livestockwebservice.service.medication.find;

import zw.co.lws.livestockwebservice.domain.Medication;
import zw.co.lws.livestockwebservice.persistence.medicalrecord.MedicationRepository;
import zw.co.lws.livestockwebservice.service.exception.ResourceNotFoundException;
import zw.co.lws.livestockwebservice.service.medication.MedicationResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sheltons
 * created at 23-Nov-2021 15:53
 */
public class FindMedicationServiceImpl implements FindMedicationService {

    private final MedicationRepository medicationRepository;

    public FindMedicationServiceImpl(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    @Override
    public MedicationResponse findById(Long id) {
        Medication medication = medicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Record with id {0} was not found", id));
        return new MedicationResponse(medication);
    }

    @Override
    public List<MedicationResponse> findMedicationRecordsByTagNumber(String tagNumber) {
        List<Medication> medicationList = medicationRepository.findMedicationRecordsByTagNumber(tagNumber);
        List<MedicationResponse> medicationResponseList = new ArrayList<>();
        medicationList.stream().forEach(medication -> medicationResponseList.add(new MedicationResponse(medication)));
        return medicationResponseList;
    }


}
