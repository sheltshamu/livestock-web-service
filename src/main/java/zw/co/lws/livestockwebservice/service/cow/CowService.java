package zw.co.lws.livestockwebservice.service.cow;

public interface CowService {
    CowResponse create(CowRequest cowRequest);
    CowResponse update(CowUpdateRequest cowUpdateRequest);
    CowResponse findByTagNumber(String tagNumber);
}
