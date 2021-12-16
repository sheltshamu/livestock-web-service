package zw.co.lws.livestockwebservice.api.cow;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.lws.livestockwebservice.service.cow.CowRequest;
import zw.co.lws.livestockwebservice.service.cow.CowResponse;
import zw.co.lws.livestockwebservice.service.cow.CowService;
import zw.co.lws.livestockwebservice.service.cow.CowUpdateRequest;

@RestController
@RequestMapping("/cow")
public class CowController {
    private final CowService cowService;

    public CowController(CowService cowService) {
        this.cowService = cowService;
    }

    @PostMapping("/create")
    public ResponseEntity<CowDto> create(@RequestBody CowRequest cowRequest){
        CowResponse cow = cowService.create(cowRequest);
        CowDto cowDto = CowDto.fromCowDto(cow.getCow());
        return new ResponseEntity<>(cowDto, HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<CowDto> update(@RequestBody CowUpdateRequest cowUpdateRequest){
        CowResponse cow  = cowService.update(cowUpdateRequest);
        CowDto cowDto = CowDto.fromCowDto(cow.getCow());
        return new ResponseEntity<>(cowDto,HttpStatus.OK);
    }

    @GetMapping("{tagNumber}")
    public ResponseEntity<CowDto> findByTagNumber(String tagNumber){
        CowResponse cow = cowService.findByTagNumber(tagNumber);
        CowDto cowDto = CowDto.fromCowDto(cow.getCow());
        return new ResponseEntity<>(cowDto,HttpStatus.OK);
    }

}
