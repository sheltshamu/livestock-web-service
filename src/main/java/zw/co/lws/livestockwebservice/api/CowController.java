package zw.co.lws.livestockwebservice.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.lws.livestockwebservice.service.cow.CowRequest;
import zw.co.lws.livestockwebservice.service.cow.CowResponse;
import zw.co.lws.livestockwebservice.service.cow.CowService;

@RestController
@RequestMapping("/cow")
public class CowController {
    private final CowService cowService;

    public CowController(CowService cowService) {
        this.cowService = cowService;
    }

    @PostMapping("/create")
    public ResponseEntity<CowDto> create(CowRequest cowRequest){
        CowResponse cow = cowService.create(cowRequest);
        CowDto cowDto = CowDto.fromCowDto(cow.getCow());
        return new ResponseEntity<>(cowDto, HttpStatus.OK);
    }


}
