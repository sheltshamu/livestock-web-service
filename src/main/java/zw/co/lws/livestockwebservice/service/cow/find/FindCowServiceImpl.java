package zw.co.lws.livestockwebservice.service.cow.find;

import zw.co.lws.livestockwebservice.domain.Cow;
import zw.co.lws.livestockwebservice.domain.enums.Status;
import zw.co.lws.livestockwebservice.persistence.cow.CowRepository;
import zw.co.lws.livestockwebservice.persistence.owner.OwnerRepository;
import zw.co.lws.livestockwebservice.service.cow.CowResponse;
import zw.co.lws.livestockwebservice.service.exception.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class FindCowServiceImpl implements FindCowService {
    private final CowRepository cowRepository;

    public FindCowServiceImpl(CowRepository cowRepository, OwnerRepository ownerRepository) {
        this.cowRepository = cowRepository;
    }

    @Override
    public CowResponse findByTagNumber(String tagNumber) {
        Cow existingCow = cowRepository.findByTagNumber(tagNumber)
                .orElseThrow(()->new ResourceNotFoundException("Cow with TagNumber {0} was Not found",tagNumber));
        Cow cow = existingCow;
        return new CowResponse(cow);
    }

}
