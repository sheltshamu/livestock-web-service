package zw.co.lws.livestockwebservice.service.cow;

import org.springframework.stereotype.Service;
import zw.co.lws.livestockwebservice.domain.Cow;
import zw.co.lws.livestockwebservice.domain.Owner;
import zw.co.lws.livestockwebservice.persistence.CowRepository;
import zw.co.lws.livestockwebservice.persistence.MedicationRecordRepository;
import zw.co.lws.livestockwebservice.persistence.OwnerRepository;
import zw.co.lws.livestockwebservice.service.exceptions.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CowServiceImpl implements CowService {
    private final CowRepository cowRepository;
    private final OwnerRepository ownerRepository;
    private final MedicationRecordRepository medicationRecordRepository;

    public CowServiceImpl(CowRepository cowRepository, OwnerRepository ownerRepository, MedicationRecordRepository medicationRecordRepository) {
        this.cowRepository = cowRepository;
        this.ownerRepository = ownerRepository;
        this.medicationRecordRepository = medicationRecordRepository;
    }

    @Override
    public CowResponse create(CowRequest cowRequest){
        Optional<Owner> owner = ownerRepository.findById(cowRequest.getOwnerId());
        if (!owner.isPresent()){
            throw new ResourceNotFoundException("Owner with id {0} was not found",cowRequest.getOwnerId());
        }
        Cow cow = Cow.builder()
                .owner(owner.get())
                .category(cowRequest.getCategory())
                .dateOfBirth(cowRequest.getDateOfBirth())
                .description(cowRequest.getDescription())
                .gender(cowRequest.getGender())
                .healthStatus(cowRequest.getHealthStatus())
                .status(cowRequest.getStatus())
                .tagNumber(cowRequest.getTagNumber())
                .type(cowRequest.getType())
                .build();
        cowRepository.save(cow);
        return new CowResponse(cow);
    }

    @Override
    public CowResponse update(CowUpdateRequest cowUpdateRequest) {
        Optional<Cow> existingCow = cowRepository.findByTagNumber(cowUpdateRequest.getTagNumber());
        if (!existingCow.isPresent()){
            throw new ResourceNotFoundException("Cow with tag number {0} was Not found",cowUpdateRequest.getTagNumber());
        }
        Optional<Cow> father = cowRepository.findByTagNumber(cowUpdateRequest.getTagNumber());

         Optional<Owner> owner = ownerRepository.findById(cowUpdateRequest.getOwnerId());
         if (!owner.isPresent()){
             throw new ResourceNotFoundException("Owner with id {0} was not found",cowUpdateRequest.getOwnerId());
         }
        Optional<Cow> mother = cowRepository.findByTagNumber(cowUpdateRequest.getTagNumber());
        if (!mother.isPresent()){
            throw new ResourceNotFoundException("Cow with tag number {0} was Not found",cowUpdateRequest.getTagNumber());
        }
        Cow cow = existingCow.get();
        cow.setCategory(cowUpdateRequest.getCategory());
        cow.setDescription(cowUpdateRequest.getDescription());
        cow.setDateOfBirth(cowUpdateRequest.getDateOfBirth());
        cow.setGender(cowUpdateRequest.getGender());
        cow.setHealthStatus(cowUpdateRequest.getHealthStatus());
        cow.setStatus(cowUpdateRequest.getStatus());
        cow.setOwner(owner.get());
        cow.setFather(father.get());
        cow.setMother(mother.get());
        cow.setType(cowUpdateRequest.getType());
        cow.setModifiedDate(LocalDateTime.now());
        return new CowResponse(cow);
    }

    @Override
    public CowResponse findByTagNumber(String tagNumber) {
        Optional<Cow> existingCow = cowRepository.findByTagNumber(tagNumber);
        if (!existingCow.isPresent()){
            throw new ResourceNotFoundException("Cow with tag number {0} was Not found",tagNumber);
        }
        Cow cow = existingCow.get();
        return new CowResponse(cow);
    }

}
