package zw.co.lws.livestockwebservice.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContactDetails {
    @Column(unique = true,length = 40)
    private String email;

    @Column(name= "mobile_number",unique = true,length = 18)
    private String mobileNumber;

}
