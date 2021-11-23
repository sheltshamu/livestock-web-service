package zw.co.lws.livestockwebservice.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.lws.livestockwebservice.service.medication.MedicationRecordRequest;
import zw.co.lws.livestockwebservice.service.medication.MedicationRecordService;
import zw.co.lws.livestockwebservice.service.medication.MedicationResponse;

/**
 * @author sheltons
 * created at 23-Nov-2021 16:42
 */
@RestController
@RequestMapping("/medication/")
public class MedicationController {
    private final MedicationRecordService medicationRecordService;

    public MedicationController(MedicationRecordService medicationRecordService) {
        this.medicationRecordService = medicationRecordService;
    }

    @PostMapping("create")
    public ResponseEntity<MedicationDto> create(@RequestBody MedicationRecordRequest medicationRecordRequest){
        MedicationResponse medication  = medicationRecordService.create(medicationRecordRequest);
        MedicationDto medicationDto = MedicationDto.of(medication.getMedicationRecord());
        return new ResponseEntity<>(medicationDto, HttpStatus.OK);

    }
}
