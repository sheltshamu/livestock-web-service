package zw.co.lws.livestockwebservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Builder
@ToString
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


    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getFullName() {
        return this.firstname + " " +this.lastname;
    }

    public String getIdentificationNumber() {
        return this.identificationNumber;
    }

    public Address getAddress() {
        return this.address;
    }

    public ContactDetails getContactDetails() {
        return this.contactDetails;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

}
