package zw.co.lws.livestockwebservice.service.cow.create;

import zw.co.lws.livestockwebservice.service.cow.CowResponse;

@FunctionalInterface
public interface CowCreateService {
    CowResponse create(CowCreateRequest cowCreateRequest);
}
