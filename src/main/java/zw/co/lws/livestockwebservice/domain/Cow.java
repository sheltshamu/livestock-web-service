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
@AllArgsConstructor
@Data
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

}
