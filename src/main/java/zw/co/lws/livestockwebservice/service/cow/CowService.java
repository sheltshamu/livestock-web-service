package zw.co.lws.livestockwebservice.service.cow;

import zw.co.lws.livestockwebservice.service.exceptions.OwnerNotFound;

@FunctionalInterface
public interface CowService {
    CowResponse create(CowRequest cowRequest);
}
