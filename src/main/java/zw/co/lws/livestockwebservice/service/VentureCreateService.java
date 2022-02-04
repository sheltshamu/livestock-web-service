package zw.co.lws.livestockwebservice.service;
@FunctionalInterface
public interface VentureCreateService {
    VentureResponse create(VentureCreateRequest createRequest);
}
