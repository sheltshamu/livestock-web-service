package zw.co.lws.livestockwebservice.service;

import zw.co.lws.livestockwebservice.domain.Cow;
import zw.co.lws.livestockwebservice.domain.Medication;
import zw.co.lws.livestockwebservice.persistence.cow.CowRepository;
import zw.co.lws.livestockwebservice.persistence.medication.MedicationRepository;
import zw.co.lws.livestockwebservice.service.exception.ResourceNotFoundException;

public class MedicationCreateServiceImpl implements MedicationCreateService{
    private final MedicationRepository medicationRepository;
    private final CowRepository cowRepository;

    public MedicationCreateServiceImpl(MedicationRepository medicationRepository, CowRepository cowRepository) {
        this.medicationRepository = medicationRepository;
        this.cowRepository = cowRepository;
    }

    @Override
    public MedicationResponse create(MedicationCreateRequest medicationCreateRequest) {
        //TODo Notify Owner
        Cow cow = cowRepository.findByTagNumber(medicationCreateRequest.getTagNumber())
                .orElseThrow(() -> new ResourceNotFoundException("Cow with tag number {0} was not found", medicationCreateRequest.getTagNumber()));
        Medication medication = Medication.builder()
                .attendedBy(medicationCreateRequest.getAttendedBy())
                .recommendedMedication(medicationCreateRequest.getRecommendedMedication())
                .diseaseName(medicationCreateRequest.getDiseaseName())
                .symptomsDescription(medicationCreateRequest.getSymptomsDescription())
                .dateAttended(medicationCreateRequest.getDateAttended())
                .tagNumber(medicationCreateRequest.getTagNumber())
                .build();
        //Todo Add persistences dates
        medicationRepository.save(medication);
        return new MedicationResponse(medication);
    }
}
