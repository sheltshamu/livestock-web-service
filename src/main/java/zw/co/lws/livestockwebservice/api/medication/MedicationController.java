package zw.co.lws.livestockwebservice.api.medication;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.lws.livestockwebservice.service.medication.MedicationRecordRequest;
import zw.co.lws.livestockwebservice.service.medication.MedicationRecordService;
import zw.co.lws.livestockwebservice.service.medication.MedicationResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sheltons
 * created at 23-Nov-2021 16:42
 */
@RestController
@RequestMapping("/medication")
@Tag(name = "Medication-Record Controller", description = "Medication-Record endpoints")
public class MedicationController {
    private final MedicationRecordService medicationRecordService;

    public MedicationController(MedicationRecordService medicationRecordService) {
        this.medicationRecordService = medicationRecordService;
    }

    @PostMapping("/create")
    public ResponseEntity<MedicationDto> create(@RequestBody MedicationRecordRequest medicationRecordRequest){
        MedicationResponse medication  = medicationRecordService.create(medicationRecordRequest);
        MedicationDto medicationDto = MedicationDto.of(medication.getMedicationRecord());
        return new ResponseEntity<>(medicationDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicationDto> findById(@PathVariable Long id){
        return new ResponseEntity(medicationRecordService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/find-all-by-tag-number")
    public ResponseEntity<List<MedicationDto>> findAllByTagNumber(@RequestParam("tagNumber") String tagNumber){
        List<MedicationResponse> medicationResponseList = medicationRecordService.findMedicationRecordsByTagNumber(tagNumber);
        List<MedicationDto> medicationDtoList = new ArrayList<>();
        medicationResponseList.stream().forEach(medicationResponse -> medicationDtoList.add(new MedicationDto(medicationResponse.getMedicationRecord())));
        return  new ResponseEntity<>(medicationDtoList,HttpStatus.OK);
    }
}
