package zw.co.lws.livestockwebservice.service.medication;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import zw.co.lws.livestockwebservice.domain.Cow;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MedicationRecordRequest {
    private String diseaseName;
    private String symptomsDescription;
    private String recommendedMedication;
    private String attendedBy;
    private LocalDateTime dateAttended;
    private String tagNumber;
}

