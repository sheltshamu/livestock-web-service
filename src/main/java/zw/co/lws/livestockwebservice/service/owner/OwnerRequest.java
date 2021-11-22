package zw.co.lws.livestockwebservice.service.owner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Getter
@AllArgsConstructor
@NoArgsConstructor
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
