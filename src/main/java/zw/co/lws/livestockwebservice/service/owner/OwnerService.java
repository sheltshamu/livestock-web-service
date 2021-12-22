package zw.co.lws.livestockwebservice.service.owner;

import zw.co.lws.livestockwebservice.domain.Owner;

import java.util.List;

public interface OwnerService {
    OwnerResponse create(OwnerRequest ownerRequest);
    OwnerResponse update(OwnerUpdateRequest ownerUpdateRequest);
    OwnerResponse getById(Long id);
    List<OwnerResponse> getAll();
}
