package zw.co.lws.livestockwebservice.service.medication;

import org.springframework.stereotype.Service;
import zw.co.lws.livestockwebservice.domain.Cow;
import zw.co.lws.livestockwebservice.domain.MedicationRecord;
import zw.co.lws.livestockwebservice.persistence.cow.CowRepository;
import zw.co.lws.livestockwebservice.persistence.medicalrecord.MedicationRecordRepository;
import zw.co.lws.livestockwebservice.service.cow.CowService;
import zw.co.lws.livestockwebservice.service.exceptions.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author sheltons
 * created at 23-Nov-2021 15:53
 */
public class MedicationRecordServiceImpl implements MedicationRecordService{

    private final MedicationRecordRepository medicationRecordRepository;
    private final CowRepository cowRepository;
    private final CowService cowService;

    public MedicationRecordServiceImpl(MedicationRecordRepository medicationRecordRepository, CowRepository cowRepository, CowService cowService) {
        this.medicationRecordRepository = medicationRecordRepository;
        this.cowRepository = cowRepository;
        this.cowService = cowService;
    }

    @Override
    public MedicationResponse create(MedicationRecordRequest medicationRecordRequest) {
        //TODo Notify Owner
        Optional<Cow> cow = cowRepository.findByTagNumber(medicationRecordRequest.getTagNumber());
        if (!cow.isPresent()){
            throw new ResourceNotFoundException("Cow with tag number {0} was not found",medicationRecordRequest.getTagNumber());
        }
        MedicationRecord medicationRecord =MedicationRecord.builder()
                .attendedBy(medicationRecordRequest.getAttendedBy())
                .recommendedMedication(medicationRecordRequest.getRecommendedMedication())
                .diseaseName(medicationRecordRequest.getDiseaseName())
                .symptomsDescription(medicationRecordRequest.getSymptomsDescription())
                .dateAttended(medicationRecordRequest.getDateAttended())
                .tagNumber(medicationRecordRequest.getTagNumber())
                .createdDate(LocalDateTime.now())
                .build();
        medicationRecordRepository.save(medicationRecord);
        return new MedicationResponse(medicationRecord);
    }

    @Override
    public MedicationResponse update(MedicationRecordUpdateRequest medicationRecordUpdateRequest) {
        Optional<MedicationRecord> existingMedication = medicationRecordRepository.findById(medicationRecordUpdateRequest.getId());
        if (!existingMedication.isPresent()){
            throw new ResourceNotFoundException("Record with id {0} was not found",medicationRecordUpdateRequest.getId());
        }
        Optional<Cow> existingCow = cowRepository.findByTagNumber(medicationRecordUpdateRequest.getTagNumber());
        if (!existingCow.isPresent()){
            throw new ResourceNotFoundException("Cow with tag number {0} was not found",medicationRecordUpdateRequest.getTagNumber());
        }
        MedicationRecord medicationRecord = existingMedication.get();
        medicationRecord.setRecommendedMedication(medicationRecordUpdateRequest.getRecommendedMedication());
        medicationRecord.setAttendedBy(medicationRecordUpdateRequest.getAttendedBy());
        medicationRecord.setModifiedDate(LocalDateTime.now());
        medicationRecord.setSymptomsDescription(medicationRecordUpdateRequest.getSymptomsDescription());
        medicationRecord.setDiseaseName(medicationRecordUpdateRequest.getDiseaseName());
        medicationRecordRepository.save(medicationRecord);
        return new MedicationResponse(medicationRecord);
    }

    @Override
    public MedicationResponse findById(Long id) {
        Optional<MedicationRecord> medicationRecord = medicationRecordRepository.findById(id);
        if (!medicationRecord.isPresent()){
            throw new  ResourceNotFoundException("Record with id {0} was not found",id);
        }
        MedicationRecord medication = medicationRecord.get();
        return new MedicationResponse(medication);
    }

    @Override
    public List<MedicationResponse> findMedicationRecordsByTagNumber(String tagNumber) {
        List<MedicationRecord> medicationRecordList = medicationRecordRepository.findMedicationRecordsByTagNumber(tagNumber);
        List<MedicationResponse> medicationResponseList = new ArrayList<>();
        medicationRecordList.stream().forEach(medicationRecord -> medicationResponseList.add(new MedicationResponse(medicationRecord)));
        return medicationResponseList;
    }


}
