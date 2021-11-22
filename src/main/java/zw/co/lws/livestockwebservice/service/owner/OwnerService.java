package zw.co.lws.livestockwebservice.service.owner;

@FunctionalInterface
public interface OwnerService {
    OwnerResponse create(OwnerRequest ownerRequest);
}
