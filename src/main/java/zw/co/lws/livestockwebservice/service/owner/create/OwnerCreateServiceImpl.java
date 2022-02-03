package zw.co.lws.livestockwebservice.service.owner.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zw.co.lws.livestockwebservice.domain.Address;
import zw.co.lws.livestockwebservice.domain.ContactDetails;
import zw.co.lws.livestockwebservice.domain.Owner;
import zw.co.lws.livestockwebservice.persistence.owner.OwnerRepository;
import zw.co.lws.livestockwebservice.service.exception.DuplicateEntryException;
import zw.co.lws.livestockwebservice.service.exception.ResourceNotFoundException;
import zw.co.lws.livestockwebservice.service.owner.OwnerResponse;

import java.time.LocalDateTime;
import java.util.Optional;

public class OwnerCreateServiceImpl implements OwnerCreateService{
    private final OwnerRepository ownerRepository;

    public OwnerCreateServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public OwnerResponse create(OwnerCreateRequest ownerCreateRequest) {
        Address address = Address.builder()
                .addressLine1(ownerCreateRequest.getAddressLine1())
                .addressLine2(ownerCreateRequest.getAddressLine2())
                .addressLine2(ownerCreateRequest.getAddressLine3())
                .build();
        ContactDetails contactDetails = ContactDetails.builder()
                .email(ownerCreateRequest.getEmail())
                .mobileNumber(ownerCreateRequest.getMobileNumber())
                .build();
        Optional<Owner> ownerEmail = ownerRepository.findOwnerByContactDetails_Email(ownerCreateRequest.getEmail());
        if (ownerEmail.isPresent()){
            throw new DuplicateEntryException("Email Already Exist");
        }
        Optional<Owner> ownerMobileNumber =ownerRepository.findOwnerByContactDetails_MobileNumber(ownerCreateRequest.getMobileNumber());
        if (ownerMobileNumber.isPresent()){
            throw new DuplicateEntryException("Mobile Number Already Exist");
        }
        Owner owner = new Owner();
        owner.setAddress(address);
        owner.setIdentificationNumber(ownerCreateRequest.getIdentificationNumber());
        owner.setFirstname(ownerCreateRequest.getFirstname());
        owner.setLastname(ownerCreateRequest.getLastname());
        owner.setContactDetails(contactDetails);
        owner.setCreatedDate(LocalDateTime.now());
        owner.setModifiedDate(LocalDateTime.now());
        ownerRepository.save(owner);
        return new OwnerResponse(owner);
    }
}
