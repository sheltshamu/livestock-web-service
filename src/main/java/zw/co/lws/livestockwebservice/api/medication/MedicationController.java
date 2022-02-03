package zw.co.lws.livestockwebservice.api.medication;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.lws.livestockwebservice.service.medication.create.MedicationCreateRequest;
import zw.co.lws.livestockwebservice.service.medication.create.MedicationCreateService;
import zw.co.lws.livestockwebservice.service.medication.find.FindMedicationService;
import zw.co.lws.livestockwebservice.service.medication.MedicationResponse;
import zw.co.lws.livestockwebservice.service.medication.update.MedicationUpdateService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/medication")
@Tag(name = "Medication-Record Controller", description = "Medication-Record endpoints")
public class MedicationController {
    private final FindMedicationService findMedicationService;
    private final MedicationCreateService medicationCreateService;
    private final MedicationUpdateService medicationUpdateService;

    public MedicationController(FindMedicationService findMedicationService, MedicationCreateService medicationCreateService, MedicationUpdateService medicationUpdateService) {
        this.findMedicationService = findMedicationService;
        this.medicationCreateService = medicationCreateService;
        this.medicationUpdateService = medicationUpdateService;
    }

    @PostMapping("/create")
    public ResponseEntity<MedicationDto> create(@RequestBody MedicationCreateRequest medicationCreateRequest){
        MedicationResponse medication  = medicationCreateService.create(medicationCreateRequest);
        MedicationDto medicationDto = MedicationDto.of(medication.getMedication());
        return new ResponseEntity<>(medicationDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicationDto> findById(@PathVariable Long id){
        return new ResponseEntity(findMedicationService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/find-all-by-tag-number")
    public ResponseEntity<List<MedicationDto>> findAllByTagNumber(@RequestParam("tagNumber") String tagNumber){
        List<MedicationResponse> medicationResponseList = findMedicationService.findMedicationRecordsByTagNumber(tagNumber);
        List<MedicationDto> medicationDtoList = new ArrayList<>();
        medicationResponseList
                .stream()
                .forEach(medicationResponse -> medicationDtoList.add(new MedicationDto(medicationResponse.getMedication())));
        return  new ResponseEntity<>(medicationDtoList,HttpStatus.OK);
    }
}
