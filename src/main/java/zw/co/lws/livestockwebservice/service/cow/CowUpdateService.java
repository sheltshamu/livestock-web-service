package zw.co.lws.livestockwebservice.service.cow;

@FunctionalInterface
public interface CowUpdateService {
    CowResponse update(CowUpdateRequest cowUpdateRequest);
}
