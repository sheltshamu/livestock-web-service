package zw.co.lws.livestockwebservice.service.cow.find;

import zw.co.lws.livestockwebservice.domain.Status;
import zw.co.lws.livestockwebservice.service.cow.CowResponse;
import zw.co.lws.livestockwebservice.service.cow.update.CowUpdateRequest;

import java.util.List;

public interface CowService {
    CowResponse findByTagNumber(String tagNumber);
    List<CowResponse> findCowsByStatus(Status status);
    List<CowResponse> findAll();
}

