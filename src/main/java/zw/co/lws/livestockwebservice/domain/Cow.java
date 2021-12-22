package zw.co.lws.livestockwebservice.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cow extends BaseEntity{
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    @Column(name = "date_created")
    private LocalDateTime createdDate;

    @Column(name = "tag_number", unique = true,length = 50)
    private String tagNumber;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @Column(name = "breed_type",length = 50,nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(length = 30,nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(nullable = false , length = 15)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(length = 200)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private Status status;

    @Column(name = "health_status", length = 25)
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
