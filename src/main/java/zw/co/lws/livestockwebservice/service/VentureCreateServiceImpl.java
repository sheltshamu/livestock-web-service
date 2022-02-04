package zw.co.lws.livestockwebservice.service;

import zw.co.lws.livestockwebservice.domain.Venture;
import zw.co.lws.livestockwebservice.persistence.venture.VentureRepository;

import java.time.LocalDateTime;

public class VentureCreateServiceImpl implements VentureCreateService {
    private final VentureRepository ventureRepository;

    public VentureCreateServiceImpl(VentureRepository ventureRepository) {
        this.ventureRepository = ventureRepository;
    }

    @Override
    public VentureResponse create(VentureCreateRequest ventureCreateRequest) {
        Venture venture = new Venture();
        venture.setName(ventureCreateRequest.getName());
        venture.setCreatedDate(LocalDateTime.now());
        venture.setModifiedDate(LocalDateTime.now());
        ventureRepository.save(venture);
        return new VentureResponse(venture);
    }
}
