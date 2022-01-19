package zw.co.lws.livestockwebservice.service.cow.find;

import zw.co.lws.livestockwebservice.domain.Cow;
import zw.co.lws.livestockwebservice.domain.Status;
import zw.co.lws.livestockwebservice.persistence.cow.CowRepository;
import zw.co.lws.livestockwebservice.persistence.owner.OwnerRepository;
import zw.co.lws.livestockwebservice.service.cow.CowResponse;
import zw.co.lws.livestockwebservice.service.exceptions.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CowServiceImpl implements CowService {
    private final CowRepository cowRepository;

    public CowServiceImpl(CowRepository cowRepository, OwnerRepository ownerRepository) {
        this.cowRepository = cowRepository;
    }

    @Override
    public CowResponse findByTagNumber(String tagNumber) {
        Cow existingCow = cowRepository.findByTagNumber(tagNumber)
                .orElseThrow(()->new ResourceNotFoundException("Cow with TagNumber {0} was Not found",tagNumber));
        Cow cow = existingCow;
        return new CowResponse(cow);
    }

    @Override
    public List<CowResponse> findCowsByStatus(Status status) {
        List<Cow> cowList = cowRepository.findCowsByStatus(status);
        List<CowResponse> cowResponseList = new ArrayList<>();
        cowList.stream().forEach(cow -> cowResponseList.add( new CowResponse(cow)));
        return cowResponseList;
    }

    @Override
    public List<CowResponse> findAll() {
        List<Cow> cowList = cowRepository.findAll();
        List<CowResponse> cowResponseList = new ArrayList<>();
        cowList.stream().forEach(cow -> cowResponseList.add(new CowResponse(cow)));
        return cowResponseList;
    }

}
