package zw.co.lws.livestockwebservice.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medication_record")
public class Medication extends BaseEntity{
    @Column(name = "disease_name",length = 200)
    private String diseaseName;
    @Column(name = "symptoms_description",length=200)
    private String symptomsDescription;
    @Column(name = "recommended_medication",length = 200)
    private String recommendedMedication;
    @Column(name = "attended_by",length = 100)
    private String attendedBy;
    @Column(name = "date_attended")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime dateAttended;
    @Column(name = "tag_number")
    private String tagNumber;

}
