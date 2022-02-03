package zw.co.lws.livestockwebservice.api.owner;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import zw.co.lws.livestockwebservice.service.owner.OwnerResponse;
import zw.co.lws.livestockwebservice.service.owner.create.OwnerCreateRequest;
import zw.co.lws.livestockwebservice.service.owner.create.OwnerCreateService;
import zw.co.lws.livestockwebservice.service.owner.create.OwnerCreateServiceImpl;
import zw.co.lws.livestockwebservice.service.owner.find.FindOwnerService;
import zw.co.lws.livestockwebservice.service.owner.update.OwnerUpdateRequest;
import zw.co.lws.livestockwebservice.service.owner.update.OwnerUpdateService;

import java.util.ArrayList;
import java.util.List;

@RestController
@Controller("/owner")
@Tag(name = "Owner Controller", description = "Owner endpoints")
public class OwnerController{
    private final FindOwnerService findOwnerService;
    private final OwnerCreateService ownerCreateService;
    private final OwnerUpdateService ownerUpdateService;

    public OwnerController(FindOwnerService findOwnerService, OwnerCreateService ownerCreateService, OwnerUpdateService ownerUpdateService) {
        this.findOwnerService = findOwnerService;
        this.ownerCreateService = ownerCreateService;
        this.ownerUpdateService = ownerUpdateService;
    }

    @PostMapping("/create")
    public ResponseEntity<OwnerDto> create(@RequestBody OwnerCreateRequest ownerCreateRequest){
        OwnerResponse owner = ownerCreateService.create(ownerCreateRequest);
        OwnerDto ownerDto = OwnerDto.fromOwnerData(owner.getOwner());
        return new ResponseEntity<>(ownerDto, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<OwnerDto> update(@RequestBody OwnerUpdateRequest ownerUpdateRequest){
        OwnerResponse owner = ownerUpdateService.update(ownerUpdateRequest);
        OwnerDto ownerDto = OwnerDto.fromOwnerData(owner.getOwner());
        return new ResponseEntity<>(ownerDto,HttpStatus.OK);
    }

    @GetMapping("/find-by/{id}")
    public ResponseEntity<OwnerDto> findById(@PathVariable("id") Long id){
        OwnerResponse ownerResponse = findOwnerService.getById(id);
        OwnerDto ownerDto = OwnerDto.fromOwnerData(ownerResponse.getOwner());
        return ResponseEntity.ok(ownerDto);
    }

}
