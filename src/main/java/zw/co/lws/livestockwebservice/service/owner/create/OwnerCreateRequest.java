package zw.co.lws.livestockwebservice.service.owner.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OwnerCreateRequest {
    private String firstname;
    private String lastname;
    private String identificationNumber;
    private String houseNo;
    private String suburb;
    private String city;
    private String email;
    private String mobileNumber;
}
