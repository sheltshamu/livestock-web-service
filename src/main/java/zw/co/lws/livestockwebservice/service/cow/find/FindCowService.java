package zw.co.lws.livestockwebservice.service.cow.find;

import zw.co.lws.livestockwebservice.domain.enums.Status;
import zw.co.lws.livestockwebservice.service.cow.CowResponse;

import java.util.List;

public interface FindCowService {
    CowResponse findByTagNumber(String tagNumber);
    List<CowResponse> findCowsByStatus(Status status);
    List<CowResponse> findAll();
}

