package zw.co.lws.livestockwebservice.service;

import zw.co.lws.livestockwebservice.domain.Partnership;
import zw.co.lws.livestockwebservice.persistence.partnership.PartnershipRepository;

import java.time.LocalDateTime;

public class PartnershipCreateServiceImpl implements PartnershipCreateService{
    private final PartnershipRepository partnershipRepository;

    public PartnershipCreateServiceImpl(PartnershipRepository partnershipRepository) {
        this.partnershipRepository = partnershipRepository;
    }

    @Override
    public PartnershipResponse create(PartnershipCreateRequest partnershipCreateRequest) {
        Partnership partnership = new Partnership();
        partnership.setName(partnershipCreateRequest.getName());
        partnership.setDateFormed(partnershipCreateRequest.getDateFormed());
        partnership.setCreatedDate(LocalDateTime.now());
        partnership.setModifiedDate(LocalDateTime.now());
        partnershipRepository.save(partnership);
        return new PartnershipResponse(partnership);
    }
}
