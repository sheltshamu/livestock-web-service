package zw.co.lws.livestockwebservice.service.owner.find;

import zw.co.lws.livestockwebservice.service.owner.OwnerResponse;

import java.util.List;

public interface FindOwnerService {
    OwnerResponse getById(Long id);
    List<OwnerResponse> getAll();
}
