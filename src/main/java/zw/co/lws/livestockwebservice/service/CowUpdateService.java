package zw.co.lws.livestockwebservice.service;

@FunctionalInterface
public interface CowUpdateService {
    CowResponse update(CowUpdateRequest cowUpdateRequest);
}
