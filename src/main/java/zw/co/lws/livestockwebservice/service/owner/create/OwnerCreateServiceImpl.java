package zw.co.lws.livestockwebservice.service.owner.create;

import zw.co.lws.livestockwebservice.domain.Address;
import zw.co.lws.livestockwebservice.domain.ContactDetails;
import zw.co.lws.livestockwebservice.domain.Owner;
import zw.co.lws.livestockwebservice.persistence.owner.OwnerRepository;
import zw.co.lws.livestockwebservice.service.exceptions.DuplicateEntryException;
import zw.co.lws.livestockwebservice.service.exceptions.ResourceNotFoundException;
import zw.co.lws.livestockwebservice.service.owner.OwnerResponse;

import java.time.LocalDateTime;

public class OwnerCreateServiceImpl implements OwnerCreateService{
    private final OwnerRepository ownerRepository;

    public OwnerCreateServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public OwnerResponse create(OwnerCreateRequest ownerCreateRequest) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        Address address = Address.builder()
                .city(ownerCreateRequest.getCity())
                .houseNo(ownerCreateRequest.getHouseNo())
                .suburb(ownerCreateRequest.getSuburb())
                .build();

        ContactDetails contactDetails = ContactDetails.builder()
                .email(ownerCreateRequest.getEmail())
                .mobileNumber(ownerCreateRequest.getMobileNumber())
                .build();

        Owner ownerEmail = ownerRepository.findOwnerByContactDetails_Email(ownerCreateRequest.getEmail())
                .orElseThrow(()-> new ResourceNotFoundException("Owner not found"));

        Owner ownerMobileNumber =ownerRepository.findOwnerByContactDetails_MobileNumber(ownerCreateRequest.getMobileNumber())
                .orElseThrow(()->  new DuplicateEntryException("Mobile Already Exist"));

        Owner owner = new Owner();
        owner.setAddress(address);
        owner.setIdentificationNumber(ownerCreateRequest.getIdentificationNumber());
        owner.setFirstname(ownerCreateRequest.getFirstname());
        owner.setLastname(ownerCreateRequest.getLastname());
        owner.setContactDetails(contactDetails);
        owner.setCreatedDate(currentDateTime);
        owner.setModifiedDate(currentDateTime);
        ownerRepository.save(owner);
        return new OwnerResponse(owner);
    }
}
