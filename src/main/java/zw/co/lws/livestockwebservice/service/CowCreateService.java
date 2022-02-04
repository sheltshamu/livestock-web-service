package zw.co.lws.livestockwebservice.service;

@FunctionalInterface
public interface CowCreateService {
    CowResponse create(CowCreateRequest cowCreateRequest);
}
