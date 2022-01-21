package zw.co.lws.livestockwebservice.service.medication.update;

import zw.co.lws.livestockwebservice.domain.Cow;
import zw.co.lws.livestockwebservice.domain.Medication;
import zw.co.lws.livestockwebservice.persistence.cow.CowRepository;
import zw.co.lws.livestockwebservice.persistence.medication.MedicationRepository;
import zw.co.lws.livestockwebservice.service.exception.ResourceNotFoundException;
import zw.co.lws.livestockwebservice.service.medication.MedicationResponse;

import java.time.LocalDateTime;

public class MedicationUpdateServiceImpl implements MedicationUpdateService{
    private final MedicationRepository medicationRepository;
    private final CowRepository cowRepository;

    public MedicationUpdateServiceImpl(MedicationRepository medicationRepository, CowRepository cowRepository) {
        this.medicationRepository = medicationRepository;
        this.cowRepository = cowRepository;
    }

    @Override
    public MedicationResponse update(MedicationUpdateRequest medicationUpdateRequest) {
        Medication medication = medicationRepository.findById(medicationUpdateRequest.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Record not found"));

        Cow existingCow = cowRepository.findByTagNumber(medicationUpdateRequest.getTagNumber())
                .orElseThrow(() -> new ResourceNotFoundException("Cow with tag number {0} was not found", medicationUpdateRequest.getTagNumber()));

        medication.setRecommendedMedication(medicationUpdateRequest.getRecommendedMedication());
        medication.setAttendedBy(medicationUpdateRequest.getAttendedBy());
        medication.setModifiedDate(LocalDateTime.now());
        medication.setSymptomsDescription(medicationUpdateRequest.getSymptomsDescription());
        medication.setDiseaseName(medicationUpdateRequest.getDiseaseName());
        medicationRepository.save(medication);
        return new MedicationResponse(medication);
    }
}
