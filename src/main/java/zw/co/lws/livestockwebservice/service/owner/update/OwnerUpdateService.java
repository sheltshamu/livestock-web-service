package zw.co.lws.livestockwebservice.service.owner.update;

import zw.co.lws.livestockwebservice.service.owner.OwnerResponse;
@FunctionalInterface
public interface OwnerUpdateService {
    OwnerResponse update(OwnerUpdateRequest ownerUpdateRequest);
}
