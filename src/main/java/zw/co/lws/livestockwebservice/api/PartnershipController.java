package zw.co.lws.livestockwebservice.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.lws.livestockwebservice.domain.OwnerPartnership;
import zw.co.lws.livestockwebservice.service.*;

@RestController
@RequestMapping("/partnership")
public class PartnershipController {
    private final AssignPartnerService assignPartnerService;
    private final PartnershipCreateService partnershipCreateService;

    public PartnershipController(AssignPartnerService assignPartnerService, PartnershipCreateService partnershipCreateService) {
        this.assignPartnerService = assignPartnerService;
        this.partnershipCreateService = partnershipCreateService;
    }

    @PostMapping("/create")
    public ResponseEntity<PartnershipDto> create(@RequestBody PartnershipCreateRequest partnershipCreateRequest){
        PartnershipResponse partnershipResponse =partnershipCreateService.create(partnershipCreateRequest);
        PartnershipDto partnershipDto= PartnershipDto.dataFromPartnership(partnershipResponse
                .getPartnership());
        return ResponseEntity.ok(partnershipDto);
    }
    @PostMapping("/assign")
    public ResponseEntity<OwnerPartnershipDto> assign(@RequestBody AssignPartnerRequest assignPartnerRequest){
        OwnerPartnerShipResponse ownerPartnerShipResponse = assignPartnerService.assign(assignPartnerRequest);
        OwnerPartnershipDto ownerPartnershipDto = OwnerPartnershipDto.dataFromOwnerPartnership(ownerPartnerShipResponse
                .getOwnerPartnership());
        return ResponseEntity.ok(ownerPartnershipDto);
    }
}
