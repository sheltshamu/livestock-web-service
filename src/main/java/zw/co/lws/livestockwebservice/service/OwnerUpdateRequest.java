package zw.co.lws.livestockwebservice.service;

import lombok.Getter;
import zw.co.lws.livestockwebservice.domain.Address;
import zw.co.lws.livestockwebservice.domain.ContactDetails;

@Getter
public class OwnerUpdateRequest {
    private Long id;
    private String firstname;
    private String lastname;
    private String identificationNumber;
    private Address address;
    private ContactDetails contactDetails;
}
