package zw.co.lws.livestockwebservice.service.cow.update;

import zw.co.lws.livestockwebservice.service.cow.CowResponse;

@FunctionalInterface
public interface CowUpdateService {
    CowResponse update(CowUpdateRequest cowUpdateRequest);
}
