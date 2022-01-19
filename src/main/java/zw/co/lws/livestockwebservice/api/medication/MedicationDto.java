package zw.co.lws.livestockwebservice.api.medication;

import zw.co.lws.livestockwebservice.domain.Medication;

import java.time.LocalDateTime;

public class MedicationDto {
    private String diseaseName;
    private String symptomsDescription;
    private String recommendedMedication;
    private String attendedBy;
    private LocalDateTime dateAttended;

    public MedicationDto() {
    }

    public MedicationDto(Medication medication){
        this.diseaseName = medication.getDiseaseName();
        this.symptomsDescription = medication.getSymptomsDescription();
        this.recommendedMedication = medication.getRecommendedMedication();
        this.attendedBy = medication.getAttendedBy();
        this.dateAttended = medication.getDateAttended();
    }

    public  static MedicationDto of(Medication medication){
        MedicationDto medicationDto = new MedicationDto();
        medicationDto.diseaseName= medication.getDiseaseName();
        medicationDto.symptomsDescription= medication.getSymptomsDescription();
        medicationDto.recommendedMedication= medication.getRecommendedMedication();
        medicationDto.attendedBy= medication.getAttendedBy();
        medicationDto.dateAttended= medication.getDateAttended();
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
