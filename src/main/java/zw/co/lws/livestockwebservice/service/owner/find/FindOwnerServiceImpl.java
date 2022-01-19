package zw.co.lws.livestockwebservice.service.owner.find;

import zw.co.lws.livestockwebservice.domain.Owner;
import zw.co.lws.livestockwebservice.persistence.owner.OwnerRepository;
import zw.co.lws.livestockwebservice.service.exception.ResourceNotFoundException;
import zw.co.lws.livestockwebservice.service.owner.OwnerResponse;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<OwnerResponse> getAll() {
        List<Owner> ownerList = ownerRepository.findAll();
        List<OwnerResponse> ownerResponseList = new ArrayList<>();
        ownerList.stream().forEach(owner -> ownerResponseList.add(new OwnerResponse(owner)));
        return ownerResponseList;
    }

}
