package zw.co.lws.livestockwebservice.api.cow;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.lws.livestockwebservice.commons.Status;
import zw.co.lws.livestockwebservice.service.cow.CowResponse;
import zw.co.lws.livestockwebservice.service.cow.create.CowCreateRequest;
import zw.co.lws.livestockwebservice.service.cow.create.CowCreateService;
import zw.co.lws.livestockwebservice.service.cow.find.FindCowService;
import zw.co.lws.livestockwebservice.service.cow.update.CowUpdateRequest;
import zw.co.lws.livestockwebservice.service.cow.update.CowUpdateService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cow")
@Tag(name = "Cow Controller", description = "Cow endpoints")
public class CowController {
    private final CowCreateService cowCreateService;
    private final CowUpdateService cowUpdateService;
    private final FindCowService findCowService;

    public CowController(CowCreateService cowCreateService, CowUpdateService cowUpdateService, FindCowService findCowService) {
        this.cowCreateService = cowCreateService;
        this.cowUpdateService = cowUpdateService;
        this.findCowService = findCowService;
    }


    @PostMapping("/create")
    public ResponseEntity<CowDto> create(@RequestBody CowCreateRequest cowCreateRequest){
        CowResponse cow = cowCreateService.create(cowCreateRequest);
        CowDto cowDto = CowDto.fromCowDto(cow.getCow());
        return new ResponseEntity<>(cowDto, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<CowDto> update(@RequestBody CowUpdateRequest cowUpdateRequest){
        CowResponse cow  = cowUpdateService.update(cowUpdateRequest);
        CowDto cowDto = CowDto.fromCowDto(cow.getCow());
        return new ResponseEntity<>(cowDto,HttpStatus.OK);
    }

    @GetMapping("find-by/{tagNumber}")
    public ResponseEntity<CowDto> findByTagNumber(@PathVariable("tagNumber") String tagNumber){
        CowResponse cow = findCowService.findByTagNumber(tagNumber);
        CowDto cowDto = CowDto.fromCowDto(cow.getCow());
        return new ResponseEntity<>(cowDto,HttpStatus.OK);
    }
}
