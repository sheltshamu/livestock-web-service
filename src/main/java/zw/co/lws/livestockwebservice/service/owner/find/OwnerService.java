package zw.co.lws.livestockwebservice.service.owner.find;

import zw.co.lws.livestockwebservice.service.owner.OwnerResponse;
import zw.co.lws.livestockwebservice.service.owner.update.OwnerUpdateRequest;

import java.util.List;

public interface OwnerService {
    OwnerResponse getById(Long id);
    List<OwnerResponse> getAll();
}
