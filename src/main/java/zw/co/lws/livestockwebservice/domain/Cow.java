package zw.co.lws.livestockwebservice.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import zw.co.lws.livestockwebservice.domain.enums.*;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Entity
@Table(name = "cow")
public class Cow extends BaseEntity{
    public Cow(){

    }
    @Column(name = "tag_number", unique = true,length = 50)
    private String tagNumber;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @Column(name = "breed",length = 50,nullable = false)
    @Enumerated(EnumType.STRING)
    private Breed breed;

    @Column(length = 30,nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(nullable = false , length = 15)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(length = 200)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(length = 25,nullable = false)
    private Status status;

    @Column(name = "health_status", length = 25,nullable = false)
    @Enumerated(EnumType.STRING)
    private HealthStatus healthStatus;

    @OneToOne
    @JoinColumn(name = "mother_id",nullable = true)
    private Cow mother;

    @OneToOne
    @JoinColumn(name = "father_id",nullable = true)
    private Cow father;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    public String getTagNumber() {
        return tagNumber;
    }

    public void setTagNumber(String tagNumber) {
        this.tagNumber = tagNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public HealthStatus getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }

    public Cow getMother() {
        return mother;
    }

    public void setMother(Cow mother) {
        this.mother = mother;
    }

    public Cow getFather() {
        return father;
    }

    public void setFather(Cow father) {
        this.father = father;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Cow{" +
                "tagNumber='" + tagNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", breed=" + breed +
                ", category=" + category +
                ", gender=" + gender +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", healthStatus=" + healthStatus +
                ", mother=" + mother +
                ", father=" + father +
                ", owner=" + owner +
                '}';
    }
}
