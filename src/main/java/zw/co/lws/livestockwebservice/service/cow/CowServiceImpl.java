package zw.co.lws.livestockwebservice.service.cow;

import org.springframework.stereotype.Service;
import zw.co.lws.livestockwebservice.domain.MedicationRecord;
import zw.co.lws.livestockwebservice.domain.Cow;
import zw.co.lws.livestockwebservice.domain.Owner;
import zw.co.lws.livestockwebservice.persistence.MedicationRecordRepository;
import zw.co.lws.livestockwebservice.persistence.CowRepository;
import zw.co.lws.livestockwebservice.persistence.OwnerRepository;
import zw.co.lws.livestockwebservice.service.exceptions.CowNotFound;
import zw.co.lws.livestockwebservice.service.exceptions.OwnerNotFound;
import zw.co.lws.livestockwebservice.service.exceptions.RecordNotFoundException;

import java.util.Optional;

@Service
public class CowServiceImpl implements CowService {
    private final CowRepository cowRepository;
    private final OwnerRepository ownerRepository;
    private final MedicationRecordRepository medicationRecordRepository;

    public CowServiceImpl(CowRepository cowRepository
            , OwnerRepository ownerRepository
            , MedicationRecordRepository medicationRecordRepository) {
        this.cowRepository = cowRepository;
        this.ownerRepository = ownerRepository;
        this.medicationRecordRepository = medicationRecordRepository;
    }

    @Override
    public CowResponse create(CowRequest cowRequest){
        Optional<Owner> owner = ownerRepository.findById(cowRequest.getOwnerId());
        if (!owner.isPresent()){
            throw new OwnerNotFound(cowRequest.getOwnerId());
        }
        Optional<Cow> father = cowRepository.findByTagNumber(cowRequest.getTagNumber());
        if (!father.isPresent()){
            throw new CowNotFound(cowRequest.getTagNumber());
        }
        Optional<Cow> mother = cowRepository.findByTagNumber(cowRequest.getTagNumber());
        if (!father.isPresent()){
            throw new CowNotFound(cowRequest.getTagNumber());
        }
        Optional<MedicationRecord> medicationRecord = medicationRecordRepository.findById(cowRequest.getMedicationRecordId());
        if (!medicationRecord.isPresent()){
            throw new RecordNotFoundException(cowRequest.getMedicationRecordId());
        }
        Cow cow = Cow.builder()
                .owner(owner.get())
                .category(cowRequest.getCategory())
                .dateOfBirth(cowRequest.getDateOfBirth())
                .description(cowRequest.getDescription())
                .father(father.get())
                .mother(mother.get())
                .gender(cowRequest.getGender())
                .healthStatus(cowRequest.getHealthStatus())
                .medicationRecord(medicationRecord.get())
                .status(cowRequest.getStatus())
                .tagNumber(cowRequest.getTagNumber())
                .type(cowRequest.getType())
                .build();
        return new CowResponse(cow);
    }
}
