package zw.co.lws.livestockwebservice.service.owner;

public interface OwnerService {
    OwnerResponse create(OwnerRequest ownerRequest);
    OwnerResponse update(OwnerUpdateRequest ownerUpdateRequest);
}
