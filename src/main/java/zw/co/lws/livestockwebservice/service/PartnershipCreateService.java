package zw.co.lws.livestockwebservice.service;
@FunctionalInterface
public interface PartnershipCreateService {
    PartnershipResponse create(PartnershipCreateRequest createRequest);
}
