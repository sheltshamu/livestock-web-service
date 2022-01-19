package zw.co.lws.livestockwebservice.service.owner.update;

import zw.co.lws.livestockwebservice.domain.Owner;
import zw.co.lws.livestockwebservice.persistence.owner.OwnerRepository;
import zw.co.lws.livestockwebservice.service.exceptions.ResourceNotFoundException;
import zw.co.lws.livestockwebservice.service.owner.OwnerResponse;

public class OwnerUpdateServiceImpl implements OwnerUpdateService{

    private final OwnerRepository ownerRepository;

    public OwnerUpdateServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public OwnerResponse update(OwnerUpdateRequest ownerUpdateRequest) {
        Owner existingOwner = ownerRepository.findById(ownerUpdateRequest.getId())
                .orElseThrow(()-> new ResourceNotFoundException("Owner with id {0} was not found",ownerUpdateRequest.getId()));
        Owner owner = existingOwner;
        owner.setIdentificationNumber(ownerUpdateRequest.getIdentificationNumber());
        owner.setContactDetails(ownerUpdateRequest.getContactDetails());
        owner.setAddress(ownerUpdateRequest.getAddress());
        owner.setFirstname(ownerUpdateRequest.getFirstname());
        owner.setLastname(ownerUpdateRequest.getLastname());
        ownerRepository.save(owner);
        return new OwnerResponse(owner);
    }
}
