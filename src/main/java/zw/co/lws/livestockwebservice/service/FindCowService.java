package zw.co.lws.livestockwebservice.service;

public interface FindCowService {
    CowResponse findByTagNumber(String tagNumber);
}

