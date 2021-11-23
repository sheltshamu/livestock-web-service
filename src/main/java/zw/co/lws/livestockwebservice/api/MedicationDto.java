package zw.co.lws.livestockwebservice.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zw.co.lws.livestockwebservice.domain.Cow;
import zw.co.lws.livestockwebservice.domain.MedicationRecord;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicationDto {
    private String diseaseName;
    private String symptomsDescription;
    private String recommendedMedication;
    private String attendedBy;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime dateAttended;

    public  static MedicationDto of(MedicationRecord medicationRecord){
        MedicationDto medicationDto = new MedicationDto();
        medicationDto.setRecommendedMedication(medicationRecord.getRecommendedMedication());
        medicationDto.setAttendedBy(medicationRecord.getAttendedBy());
        medicationDto.setDateAttended(medicationRecord.getDateAttended());
        medicationDto.setSymptomsDescription(medicationRecord.getSymptomsDescription());
        medicationDto.setDiseaseName(medicationRecord.getDiseaseName());
        return medicationDto;
    }
}
