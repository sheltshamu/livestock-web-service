package zw.co.lws.livestockwebservice.service.owner.create;

import zw.co.lws.livestockwebservice.service.owner.OwnerResponse;

@FunctionalInterface
public interface OwnerCreateService {
    OwnerResponse create(OwnerCreateRequest ownerCreateRequest);
}
