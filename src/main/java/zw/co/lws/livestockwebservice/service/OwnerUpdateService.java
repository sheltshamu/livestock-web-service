package zw.co.lws.livestockwebservice.service;

@FunctionalInterface
public interface OwnerUpdateService {
    OwnerResponse update(OwnerUpdateRequest ownerUpdateRequest);
}
