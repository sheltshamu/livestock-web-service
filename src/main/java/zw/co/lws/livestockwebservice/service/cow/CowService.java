package zw.co.lws.livestockwebservice.service.cow;

import zw.co.lws.livestockwebservice.service.exceptions.OwnerNotFound;
public interface CowService {
    CowResponse create(CowRequest cowRequest);
    CowResponse update(CowUpdateRequest cowUpdateRequest);
    CowResponse findByTagNumber(String tagNumber);
}
