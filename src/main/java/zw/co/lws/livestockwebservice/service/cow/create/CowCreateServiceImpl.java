package zw.co.lws.livestockwebservice.service.cow.create;

import zw.co.lws.livestockwebservice.domain.Cow;
import zw.co.lws.livestockwebservice.domain.Owner;
import zw.co.lws.livestockwebservice.persistence.cow.CowRepository;
import zw.co.lws.livestockwebservice.persistence.owner.OwnerRepository;
import zw.co.lws.livestockwebservice.service.cow.CowResponse;
import zw.co.lws.livestockwebservice.service.exceptions.DuplicateEntryException;
import zw.co.lws.livestockwebservice.service.exceptions.ResourceNotFoundException;

import java.util.Optional;

public class CowCreateServiceImpl implements CowCreateService{
    private final OwnerRepository ownerRepository;
    private final CowRepository cowRepository;

    public CowCreateServiceImpl(OwnerRepository ownerRepository, CowRepository cowRepository) {
        this.ownerRepository = ownerRepository;
        this.cowRepository = cowRepository;
    }
    @Override
    public CowResponse create(CowCreateRequest cowCreateRequest){
        Optional<Owner> owner = ownerRepository.findById(cowCreateRequest.getOwnerId());
        if (!owner.isPresent()){
            throw new ResourceNotFoundException("Owner with id {0} was not found",cowCreateRequest.getOwnerId());
        }
        Optional<Cow> existingCow = cowRepository.findByTagNumber(cowCreateRequest.getTagNumber());
        if (existingCow.isPresent()){
            throw new DuplicateEntryException("Tag number {0} is already in use",cowCreateRequest.getTagNumber());
        }
        Cow cow = Cow.builder()
                .owner(owner.get())
                .category(cowCreateRequest.getCategory())
                .dateOfBirth(cowCreateRequest.getDateOfBirth())
                .description(cowCreateRequest.getDescription())
                .gender(cowCreateRequest.getGender())
                .healthStatus(cowCreateRequest.getHealthStatus())
                .status(cowCreateRequest.getStatus())
                .tagNumber(cowCreateRequest.getTagNumber())
                .type(cowCreateRequest.getType())
                .build();
        cowRepository.save(cow);
        return new CowResponse(cow);
    }
}
