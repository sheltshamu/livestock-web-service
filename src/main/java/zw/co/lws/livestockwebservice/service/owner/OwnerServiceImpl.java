package zw.co.lws.livestockwebservice.service.owner;

import org.springframework.stereotype.Service;
import zw.co.lws.livestockwebservice.domain.Address;
import zw.co.lws.livestockwebservice.domain.ContactDetails;
import zw.co.lws.livestockwebservice.domain.Owner;
import zw.co.lws.livestockwebservice.persistence.owner.OwnerRepository;
import zw.co.lws.livestockwebservice.service.exceptions.DuplicateEntryException;
import zw.co.lws.livestockwebservice.service.exceptions.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public OwnerResponse create(OwnerRequest ownerRequest) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        Address address = Address.builder()
                .city(ownerRequest.getCity())
                .houseNo(ownerRequest.getHouseNo())
                .suburb(ownerRequest.getSuburb())
                .build();

        ContactDetails contactDetails = ContactDetails.builder()
                .email(ownerRequest.getEmail())
                .mobileNumber(ownerRequest.getMobileNumber())
                .build();

      Owner ownerEmail = ownerRepository.findOwnerByContactDetails_Email(ownerRequest.getEmail())
              .orElseThrow(()-> new ResourceNotFoundException("Owner not found"));

      Owner ownerMobileNumber =ownerRepository.findOwnerByContactDetails_MobileNumber(ownerRequest.getMobileNumber())
                .orElseThrow(()->  new DuplicateEntryException("Mobile Already Exist"));

        Owner owner = new Owner();
        owner.setAddress(address);
        owner.setIdentificationNumber(ownerRequest.getIdentificationNumber());
        owner.setFirstname(ownerRequest.getFirstname());
        owner.setLastname(ownerRequest.getLastname());
        owner.setContactDetails(contactDetails);
        owner.setCreatedDate(currentDateTime);
        owner.setModifiedDate(currentDateTime);
        ownerRepository.save(owner);
        return new OwnerResponse(owner);
    }

    @Override
    public OwnerResponse update(OwnerUpdateRequest ownerUpdateRequest) {
        Optional<Owner> existingOwner = ownerRepository.findById(ownerUpdateRequest.getId());
        if (!existingOwner.isPresent()) {
            throw new ResourceNotFoundException("Owner with id {0} was not found",ownerUpdateRequest.getId());
        }
        Owner owner = existingOwner.get();
        owner.setIdentificationNumber(ownerUpdateRequest.getIdentificationNumber());
        owner.setContactDetails(ownerUpdateRequest.getContactDetails());
        owner.setAddress(ownerUpdateRequest.getAddress());
        owner.setFirstname(ownerUpdateRequest.getFirstname());
        owner.setLastname(ownerUpdateRequest.getLastname());
        ownerRepository.save(owner);
        return new OwnerResponse(owner);
    }

    @Override
    public OwnerResponse getById(Long id) {
        Optional<Owner> existingOwner = ownerRepository.findById(id);
        if (!existingOwner.isPresent()) {
            throw new ResourceNotFoundException("Owner with id {0} was not found",id);
        }
        Owner owner = existingOwner.get();
        return new OwnerResponse(owner);

    }

    @Override
    public List<OwnerResponse> getAll() {
        List<Owner> ownerList = ownerRepository.findAll();
        List<OwnerResponse> ownerResponseList = new ArrayList<>();
        ownerList.stream().forEach(owner -> ownerResponseList.add(new OwnerResponse(owner)));
        return ownerResponseList;
    }

}
