package zw.co.lws.livestockwebservice.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medication_record")
public class MedicationRecord extends BaseEntity{
    /**
     *
     * disease_name
     * condition
     * symptoms_description
     * recommended_medication;
     * attended by
     * attended on Date
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "disease_name",length = 200)
    private String diseaseName;
    @Column(name = "symptoms_description")
    private String symptomsDescription;
    @Column(name = "recommended_medication")
    private String recommendedMedication;
    @Column(name = "attended_by",length = 100)
    private String attendedBy;
    @Column(name = "date_attended")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime dateAttended;
    @OneToOne
    @JoinColumn(name = "cow_id")
    private Cow cow;
}
