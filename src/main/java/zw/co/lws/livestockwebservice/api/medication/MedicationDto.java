package zw.co.lws.livestockwebservice.api.medication;

import zw.co.lws.livestockwebservice.domain.MedicationRecord;

import java.time.LocalDateTime;

public class MedicationDto {
    private String diseaseName;
    private String symptomsDescription;
    private String recommendedMedication;
    private String attendedBy;
    private LocalDateTime dateAttended;

    public MedicationDto() {
    }

    public MedicationDto(MedicationRecord medicationRecord){
        this.diseaseName = medicationRecord.getDiseaseName();
        this.symptomsDescription = medicationRecord.getSymptomsDescription();
        this.recommendedMedication = medicationRecord.getRecommendedMedication();
        this.attendedBy = medicationRecord.getAttendedBy();
        this.dateAttended = medicationRecord.getDateAttended();
    }

    public  static MedicationDto of(MedicationRecord medicationRecord){
        MedicationDto medicationDto = new MedicationDto();
        medicationDto.diseaseName=medicationRecord.getDiseaseName();
        medicationDto.symptomsDescription=medicationRecord.getSymptomsDescription();
        medicationDto.recommendedMedication=medicationRecord.getRecommendedMedication();
        medicationDto.attendedBy=medicationRecord.getAttendedBy();
        medicationDto.dateAttended=medicationRecord.getDateAttended();
        return medicationDto;
    }

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
}
