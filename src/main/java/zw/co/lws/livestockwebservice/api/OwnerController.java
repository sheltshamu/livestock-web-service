package zw.co.lws.livestockwebservice.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.lws.livestockwebservice.service.owner.OwnerRequest;
import zw.co.lws.livestockwebservice.service.owner.OwnerResponse;
import zw.co.lws.livestockwebservice.service.owner.OwnerService;

@RestController
@Controller("/owner")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/create")
    public ResponseEntity<OwnerDto> create(OwnerRequest ownerRequest){
        OwnerResponse owner = ownerService.create(ownerRequest);
        OwnerDto ownerDto = OwnerDto.fromOwnerData(owner.getOwner());
        return new ResponseEntity<>(ownerDto,HttpStatus.OK);
    }
}
