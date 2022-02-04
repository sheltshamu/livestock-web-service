package zw.co.lws.livestockwebservice.service;

@FunctionalInterface
public interface OwnerCreateService {
    OwnerResponse create(OwnerCreateRequest ownerCreateRequest);
}
