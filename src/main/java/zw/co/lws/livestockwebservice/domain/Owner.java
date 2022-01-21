package zw.co.lws.livestockwebservice.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Owner extends BaseEntity{
    @Column(name = "first_name",length = 35, nullable = false)
    private String firstname;

    @Column(name = "last_name",length = 35, nullable = false)
    private String lastname;

    @Transient
    private String fullName;

    @Column(name = "identification_number",length = 35, nullable = false,unique = true)
    private String identificationNumber;

    @Embedded
    private Address address;

    @Embedded
    private ContactDetails contactDetails;

    public String getFullName() {
        return this.firstname + " " +this.lastname;
    }



}
