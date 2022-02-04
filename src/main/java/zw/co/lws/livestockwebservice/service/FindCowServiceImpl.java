package zw.co.lws.livestockwebservice.service;

import zw.co.lws.livestockwebservice.domain.Cow;
import zw.co.lws.livestockwebservice.persistence.cow.CowRepository;
import zw.co.lws.livestockwebservice.persistence.owner.OwnerRepository;
import zw.co.lws.livestockwebservice.service.exception.ResourceNotFoundException;

public class FindCowServiceImpl implements FindCowService {
    private final CowRepository cowRepository;

    public FindCowServiceImpl(CowRepository cowRepository, OwnerRepository ownerRepository) {
        this.cowRepository = cowRepository;
    }

    @Override
    public CowResponse findByTagNumber(String tagNumber) {
        Cow cow = cowRepository.findByTagNumber(tagNumber)
                .orElseThrow(()->new ResourceNotFoundException("Cow with TagNumber {0} was Not found",tagNumber));
        return new CowResponse(cow);
    }

}
