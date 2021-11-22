package zw.co.lws.livestockwebservice.service.owner;

import lombok.Getter;

import javax.persistence.Column;

@Getter
public class OwnerRequest {
    private String firstname;
    private String lastname;
    private String identificationNumber;
    private String houseNo;
    private String suburb;
    private String city;
    private String email;
    private String mobileNumber;
}
