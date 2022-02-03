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
@Table(name = "medication_record")
public class Medication extends BaseEntity{
    public Medication() {
    }
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

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getSymptomsDescription() {
        return symptomsDescription;
    }

    public void setSymptomsDescription(String symptomsDescription) {
        this.symptomsDescription = symptomsDescription;
    }

    public String getRecommendedMedication() {
        return recommendedMedication;
    }

    public void setRecommendedMedication(String recommendedMedication) {
        this.recommendedMedication = recommendedMedication;
    }

    public String getAttendedBy() {
        return attendedBy;
    }

    public void setAttendedBy(String attendedBy) {
        this.attendedBy = attendedBy;
    }

    public LocalDateTime getDateAttended() {
        return dateAttended;
    }

    public void setDateAttended(LocalDateTime dateAttended) {
        this.dateAttended = dateAttended;
    }

    public String getTagNumber() {
        return tagNumber;
    }

    public void setTagNumber(String tagNumber) {
        this.tagNumber = tagNumber;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "diseaseName='" + diseaseName + '\'' +
                ", symptomsDescription='" + symptomsDescription + '\'' +
                ", recommendedMedication='" + recommendedMedication + '\'' +
                ", attendedBy='" + attendedBy + '\'' +
                ", dateAttended=" + dateAttended +
                ", tagNumber='" + tagNumber + '\'' +
                '}';
    }
}
