package zw.co.lws.livestockwebservice.domain;

import lombok.*;

import javax.persistence.*;
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "owner")
public class Owner extends BaseEntity{
    public Owner() {
    }

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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", fullName='" + fullName + '\'' +
                ", identificationNumber='" + identificationNumber + '\'' +
                ", address=" + address +
                ", contactDetails=" + contactDetails +
                '}';
    }
}
