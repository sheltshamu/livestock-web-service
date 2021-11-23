package zw.co.lws.livestockwebservice.service.medication;

import zw.co.lws.livestockwebservice.domain.Cow;
import zw.co.lws.livestockwebservice.domain.MedicationRecord;
import zw.co.lws.livestockwebservice.persistence.CowRepository;
import zw.co.lws.livestockwebservice.persistence.MedicationRecordRepository;
import zw.co.lws.livestockwebservice.service.cow.CowService;
import zw.co.lws.livestockwebservice.service.exceptions.CowNotFound;
import zw.co.lws.livestockwebservice.service.exceptions.RecordNotFoundException;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author sheltons
 * created at 23-Nov-2021 15:53
 */
public class MedicationRecordServiceImpl implements MedicationRecordService{

    private final MedicationRecordRepository medicationRecordRepository;
    private final CowRepository cowRepository;

    public MedicationRecordServiceImpl(MedicationRecordRepository medicationRecordRepository, CowRepository cowRepository) {
        this.medicationRecordRepository = medicationRecordRepository;
        this.cowRepository = cowRepository;
    }

    @Override
    public MedicationResponse create(MedicationRecordRequest medicationRecordRequest) {
        //TODo Notify
        Optional<Cow> cow = cowRepository.findByTagNumber(medicationRecordRequest.getTagNumber());
        if (!cow.isPresent()){
            throw new CowNotFound(medicationRecordRequest.getTagNumber());
        }
        MedicationRecord medicationRecord =MedicationRecord.builder()
                .attendedBy(medicationRecordRequest.getAttendedBy())
                .recommendedMedication(medicationRecordRequest.getRecommendedMedication())
                .diseaseName(medicationRecordRequest.getDiseaseName())
                .symptomsDescription(medicationRecordRequest.getSymptomsDescription())
                .cow(cow.get())
                .dateAttended(medicationRecordRequest.getDateAttended())
                .build();
        medicationRecordRepository.save(medicationRecord);
        return new MedicationResponse(medicationRecord);
    }

    @Override
    public MedicationResponse update(MedicationRecordUpdateRequest medicationRecordUpdateRequest) {
        Optional<MedicationRecord> existingMedication = medicationRecordRepository.findById(medicationRecordUpdateRequest.getId());
        if (!existingMedication.isPresent()){
            throw new RecordNotFoundException(medicationRecordUpdateRequest.getId());
        }
        Optional<Cow> existingCow = cowRepository.findByTagNumber(medicationRecordUpdateRequest.getTagNumber());
        if (!existingCow.isPresent()){
            throw new CowNotFound(medicationRecordUpdateRequest.getTagNumber());
        }
        MedicationRecord medicationRecord = existingMedication.get();
        medicationRecord.setRecommendedMedication(medicationRecordUpdateRequest.getRecommendedMedication());
        medicationRecord.setCow(existingCow.get());
        medicationRecord.setAttendedBy(medicationRecordUpdateRequest.getAttendedBy());
        medicationRecord.setModifiedDate(LocalDateTime.now());
        medicationRecord.setSymptomsDescription(medicationRecordUpdateRequest.getSymptomsDescription());
        medicationRecord.setDiseaseName(medicationRecordUpdateRequest.getDiseaseName());
        return new MedicationResponse(medicationRecord);
    }
}
