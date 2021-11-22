package zw.co.lws.livestockwebservice.service.owner;

import org.springframework.stereotype.Service;
import zw.co.lws.livestockwebservice.domain.Address;
import zw.co.lws.livestockwebservice.domain.ContactDetails;
import zw.co.lws.livestockwebservice.domain.Owner;
import zw.co.lws.livestockwebservice.persistence.OwnerRepository;

import java.time.LocalDateTime;

@Service
public class OwnerServiceImpl implements OwnerService{
    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public OwnerResponse create(OwnerRequest ownerRequest) {
        LocalDateTime currentDateTime =LocalDateTime.now();
        Address address = Address.builder()
                .city(ownerRequest.getCity())
                .houseNo(ownerRequest.getHouseNo())
                .suburb(ownerRequest.getSuburb())
                .build();

        ContactDetails contactDetails =ContactDetails.builder()
                .email(ownerRequest.getEmail())
                .mobileNumber(ownerRequest.getMobileNumber())
                .build();

        Owner owner =new Owner();
        owner.setAddress(address);
        owner.setFirstname(owner.getFirstname());
        owner.setLastname(ownerRequest.getLastname());
        owner.setFullName(ownerRequest.getFirstname() + " " +ownerRequest.getLastname());
        owner.setContactDetails(contactDetails);
        owner.setCreatedDate(currentDateTime);
        owner.setModifiedDate(currentDateTime);
        ownerRepository.save(owner);
        return new OwnerResponse(owner);
    }
}
