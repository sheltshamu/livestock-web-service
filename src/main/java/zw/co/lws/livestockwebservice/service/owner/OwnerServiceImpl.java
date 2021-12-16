package zw.co.lws.livestockwebservice.service.owner;

import org.springframework.stereotype.Service;
import zw.co.lws.livestockwebservice.domain.Address;
import zw.co.lws.livestockwebservice.domain.ContactDetails;
import zw.co.lws.livestockwebservice.domain.Owner;
import zw.co.lws.livestockwebservice.persistence.OwnerRepository;
import zw.co.lws.livestockwebservice.service.exceptions.DuplicateEntryException;
import zw.co.lws.livestockwebservice.service.exceptions.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
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

        Optional<Owner> ownerEmail = Optional.ofNullable(ownerRepository.findOwnerByContactDetails_Email(ownerRequest.getEmail()));
        if (ownerEmail.isPresent()){
            throw new DuplicateEntryException("Oops.. Email Already Exist");
        }
        Optional<Owner> ownerMobileNumber = Optional.ofNullable(ownerRepository.findOwnerByContactDetails_MobileNumber(ownerRequest.getMobileNumber()));
        if (ownerMobileNumber.isPresent()){
            throw new DuplicateEntryException("Oops.. Mobile number Already Exist");
        }

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
        if (existingOwner.isPresent()) {
            throw new ResourceNotFoundException("Owner with id {0} was not found",id);
        }
        Owner owner = existingOwner.get();
        return new OwnerResponse(owner);

    }

    @Override
    public List<Owner> getAll() {
        return ownerRepository.findAll();
    }

}
