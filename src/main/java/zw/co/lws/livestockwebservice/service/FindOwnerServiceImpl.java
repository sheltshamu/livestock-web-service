package zw.co.lws.livestockwebservice.service;

import zw.co.lws.livestockwebservice.domain.Owner;
import zw.co.lws.livestockwebservice.persistence.owner.OwnerRepository;
import zw.co.lws.livestockwebservice.service.exception.ResourceNotFoundException;

public class FindOwnerServiceImpl implements FindOwnerService {
    private final OwnerRepository ownerRepository;

    public FindOwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public OwnerResponse getById(Long id) {
        Owner existingOwner = ownerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Owner with id {0} was not found",id));

        return new OwnerResponse(existingOwner);

    }

}
