package zw.co.lws.livestockwebservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@Data
@Builder
public class ContactDetails {
    public ContactDetails() {
    }

    @Column(unique = true,length = 40)
    private String email;

    @Column(name= "mobile_number",unique = true,length = 18)
    private String mobileNumber;

}
