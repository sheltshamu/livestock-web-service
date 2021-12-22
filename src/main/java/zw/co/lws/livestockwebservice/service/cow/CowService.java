package zw.co.lws.livestockwebservice.service.cow;

import zw.co.lws.livestockwebservice.api.cow.CowDto;
import zw.co.lws.livestockwebservice.domain.Cow;
import zw.co.lws.livestockwebservice.domain.Status;

import java.util.List;

public interface CowService {
    CowResponse create(CowRequest cowRequest);
    CowResponse update(CowUpdateRequest cowUpdateRequest);
    CowResponse findByTagNumber(String tagNumber);
    List<CowResponse> findCowsByStatus(Status status);
    List<CowResponse> findAll();
    CowResponse updateOwner(String TagNumber,Long ownerId);
    CowResponse updateCowStatus(String tagNumber,Status status);
}

