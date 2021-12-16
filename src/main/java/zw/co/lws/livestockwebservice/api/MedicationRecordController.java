package zw.co.lws.livestockwebservice.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.lws.livestockwebservice.service.medication.MedicationRecordService;

@RestController
@RequestMapping("medication-record")
public class MedicationRecordController {
    private final MedicationRecordService medicationRecordService;

    public MedicationRecordController(MedicationRecordService medicationRecordService) {
        this.medicationRecordService = medicationRecordService;
    }


}
