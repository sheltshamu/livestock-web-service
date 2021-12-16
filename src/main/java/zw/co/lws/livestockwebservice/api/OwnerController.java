package zw.co.lws.livestockwebservice.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import zw.co.lws.livestockwebservice.commons.Response;
import zw.co.lws.livestockwebservice.domain.Owner;
import zw.co.lws.livestockwebservice.service.owner.OwnerRequest;
import zw.co.lws.livestockwebservice.service.owner.OwnerResponse;
import zw.co.lws.livestockwebservice.service.owner.OwnerService;
import zw.co.lws.livestockwebservice.service.owner.OwnerUpdateRequest;

import java.util.ArrayList;
import java.util.List;

@RestController
@Controller("/owner")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/create")
    public ResponseEntity<OwnerDto> create(@RequestBody OwnerRequest ownerRequest){
        OwnerResponse owner = ownerService.create(ownerRequest);
        OwnerDto ownerDto = OwnerDto.fromOwnerData(owner.getOwner());
        return new ResponseEntity<>(ownerDto,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<OwnerDto> update(@RequestBody OwnerUpdateRequest ownerUpdateRequest){
        OwnerResponse owner = ownerService.update(ownerUpdateRequest);
        OwnerDto ownerDto = OwnerDto.fromOwnerData(owner.getOwner());
        return new ResponseEntity<>(ownerDto,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Response<OwnerDto> findById(@PathVariable("id") Long id){
        OwnerResponse ownerResponse = ownerService.getById(id);
        OwnerDto ownerDto = OwnerDto.fromOwnerData(ownerResponse.getOwner());
        return new Response<>(ownerDto).ok();
    }

    @GetMapping("/get-all")
    public List<Owner> getAll(){
       // List<Owner> ownerList = ownerService.getAll();
        return ownerService.getAll();
    }
}
