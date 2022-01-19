package zw.co.lws.livestockwebservice.service.cow.update;

import zw.co.lws.livestockwebservice.domain.Cow;
import zw.co.lws.livestockwebservice.domain.Owner;
import zw.co.lws.livestockwebservice.persistence.cow.CowRepository;
import zw.co.lws.livestockwebservice.persistence.owner.OwnerRepository;
import zw.co.lws.livestockwebservice.service.cow.CowResponse;
import zw.co.lws.livestockwebservice.service.exceptions.ResourceNotFoundException;

import java.time.LocalDateTime;

public class CowUpdateServiceImpl implements CowUpdateService{
    private final CowRepository cowRepository;
    private final OwnerRepository ownerRepository;

    public CowUpdateServiceImpl(CowRepository cowRepository, OwnerRepository ownerRepository) {
        this.cowRepository = cowRepository;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public CowResponse update(CowUpdateRequest cowUpdateRequest) {
        Cow existingCow = cowRepository.findByTagNumber(cowUpdateRequest.getTagNumber())
                .orElseThrow(()-> new ResourceNotFoundException("TagNumber {0} Not found",cowUpdateRequest.getTagNumber()));

        Cow father = cowRepository.findByTagNumber(cowUpdateRequest.getTagNumber())
                .orElseThrow(()-> new ResourceNotFoundException("TagNumber {0} Not found",cowUpdateRequest.getTagNumber()));

        Owner owner = ownerRepository.findById(cowUpdateRequest.getOwnerId())
                .orElseThrow(()->new ResourceNotFoundException("Owner with id {0} was not found",cowUpdateRequest.getOwnerId()));

        Cow mother = cowRepository.findByTagNumber(cowUpdateRequest.getTagNumber())
                .orElseThrow(()-> new ResourceNotFoundException("TagNumber {0} Not found",cowUpdateRequest.getTagNumber()));

        Cow cow = existingCow;
        cow.setCategory(cowUpdateRequest.getCategory());
        cow.setDescription(cowUpdateRequest.getDescription());
        cow.setDateOfBirth(cowUpdateRequest.getDateOfBirth());
        cow.setGender(cowUpdateRequest.getGender());
        cow.setHealthStatus(cowUpdateRequest.getHealthStatus());
        cow.setStatus(cowUpdateRequest.getStatus());
        cow.setOwner(owner);
        cow.setFather(father);
        cow.setMother(mother);
        cow.setType(cowUpdateRequest.getType());
        cow.setModifiedDate(LocalDateTime.now());
        cowRepository.save(cow);
        return new CowResponse(cow);
    }

}
