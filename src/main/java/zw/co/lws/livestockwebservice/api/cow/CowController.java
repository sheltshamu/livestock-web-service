package zw.co.lws.livestockwebservice.api.cow;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.lws.livestockwebservice.domain.Status;
import zw.co.lws.livestockwebservice.service.cow.create.CowCreateRequest;
import zw.co.lws.livestockwebservice.service.cow.CowResponse;
import zw.co.lws.livestockwebservice.service.cow.find.CowService;
import zw.co.lws.livestockwebservice.service.cow.update.CowUpdateRequest;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cow")
@Tag(name = "Cow Controller", description = "Cow endpoints")
public class CowController {
    private final CowService cowService;

    public CowController(CowService cowService) {
        this.cowService = cowService;
    }
/*
    @PostMapping("/create")
    public ResponseEntity<CowDto> create(@RequestBody CowCreateRequest cowCreateRequest){
        CowResponse cow = cowService.create(cowCreateRequest);
        CowDto cowDto = CowDto.fromCowDto(cow.getCow());
        return new ResponseEntity<>(cowDto, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<CowDto> update(@RequestBody CowUpdateRequest cowUpdateRequest){
        CowResponse cow  = cowService.update(cowUpdateRequest);
        CowDto cowDto = CowDto.fromCowDto(cow.getCow());
        return new ResponseEntity<>(cowDto,HttpStatus.OK);
    }

    @GetMapping("find-by/{tagNumber}")
    public ResponseEntity<CowDto> findByTagNumber(@PathVariable("tagNumber") String tagNumber){
        CowResponse cow = cowService.findByTagNumber(tagNumber);
        CowDto cowDto = CowDto.fromCowDto(cow.getCow());
        return new ResponseEntity<>(cowDto,HttpStatus.OK);
    }



    @GetMapping("/get-all-by/{status}")
    public ResponseEntity<List<CowDto>> findAllByStatus(@PathVariable Status status){
        List<CowResponse> cowResponseList = cowService.findCowsByStatus(status);
        List<CowDto> cowDtoList = new ArrayList<>();
        cowResponseList.stream().forEach(cowResponse -> cowDtoList.add(new CowDto(cowResponse.getCow())));
        return new ResponseEntity<List<CowDto>>(cowDtoList,HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<CowDto>> getAll(){
        List<CowResponse> cowResponseList = cowService.findAll();
        List<CowDto> cowDtos = new ArrayList<>();
        cowResponseList.stream().forEach(cowResponse -> cowDtos.add(new CowDto(cowResponse.getCow())));
        return new ResponseEntity<>(cowDtos,HttpStatus.OK);
    }

    @PutMapping("/owner-update/{tagNumber}/{ownerId}")
    public ResponseEntity<CowDto> updateOwner(@PathVariable String tagNumber,@PathVariable Long ownerId){
        CowResponse cow  = cowService.updateOwner(tagNumber,ownerId);
        CowDto cowDto = CowDto.fromCowDto(cow.getCow());
        return new ResponseEntity<>(cowDto,HttpStatus.OK);
    }

    @PutMapping("/update-cow-status/{tagNumber}/{status}")
    public ResponseEntity<CowDto> updateOwner(@PathVariable String tagNumber,@PathVariable Status status){
        CowResponse cow  = cowService.updateCowStatus(tagNumber,status);
        CowDto cowDto = CowDto.fromCowDto(cow.getCow());
        return new ResponseEntity<>(cowDto,HttpStatus.OK);
    }
*/
}
