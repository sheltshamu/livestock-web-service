package zw.co.lws.livestockwebservice.service.owner.update;

import zw.co.lws.livestockwebservice.domain.Owner;
import zw.co.lws.livestockwebservice.persistence.owner.OwnerRepository;
import zw.co.lws.livestockwebservice.service.exception.ResourceNotFoundException;
import zw.co.lws.livestockwebservice.service.owner.OwnerResponse;

import java.time.LocalDateTime;

public class OwnerUpdateServiceImpl implements OwnerUpdateService{

    private final OwnerRepository ownerRepository;

    public OwnerUpdateServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public OwnerResponse update(OwnerUpdateRequest ownerUpdateRequest) {
        Owner owner = ownerRepository.findById(ownerUpdateRequest.getId())
                .orElseThrow(()-> new ResourceNotFoundException("Owner with id {0} was not found",ownerUpdateRequest.getId()));
        owner.setIdentificationNumber(ownerUpdateRequest.getIdentificationNumber());
        owner.setContactDetails(ownerUpdateRequest.getContactDetails());
        owner.setAddress(ownerUpdateRequest.getAddress());
        owner.setFirstname(ownerUpdateRequest.getFirstname());
        owner.setLastname(ownerUpdateRequest.getLastname());
        owner.setModifiedDate(LocalDateTime.now());
        ownerRepository.save(owner);
        return new OwnerResponse(owner);
    }
}
