package zw.co.lws.livestockwebservice.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.lws.livestockwebservice.service.*;

@RestController
@RequestMapping("/partnership")
public class VentureController {
    private final VentureCreateService ventureCreateService;

    public VentureController(VentureCreateService ventureCreateService) {
        this.ventureCreateService = ventureCreateService;
    }

    @PostMapping("/create")
    public ResponseEntity<VentureDto> create(@RequestBody VentureCreateRequest ventureCreateRequest){
        VentureResponse ventureResponse = ventureCreateService.create(ventureCreateRequest);
        VentureDto ventureDto = VentureDto.dataFromVenture(ventureResponse
                .getPartnership());
        return ResponseEntity.ok(ventureDto);
    }

}
