package zw.co.lws.livestockwebservice.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import zw.co.lws.livestockwebservice.domain.Owner;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDto {
    private String firstname;
    private String lastname;
    private String email;
    private String mobileNumber;
    private String fullname;

    public OwnerDto(Owner owner){
        this.firstname=owner.getFirstname();
        this.lastname=owner.getLastname();
        this.email=owner.getContactDetails().getEmail();
        this.mobileNumber=owner.getContactDetails().getMobileNumber();
        this.fullname = owner.getFullName();
    }

    public static OwnerDto fromOwnerData(Owner owner){
        OwnerDto ownerDto = new OwnerDto();
        ownerDto.setFirstname(owner.getFirstname());
        ownerDto.setLastname(owner.getLastname());
        ownerDto.setMobileNumber(owner.getContactDetails().getMobileNumber());
        ownerDto.setEmail(owner.getContactDetails().getEmail());
        ownerDto.setFullname(owner.getFirstname()+" "+owner.getLastname());
        return ownerDto;
    }


}
