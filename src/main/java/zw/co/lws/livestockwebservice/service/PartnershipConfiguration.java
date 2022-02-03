package zw.co.lws.livestockwebservice.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zw.co.lws.livestockwebservice.persistence.owner.OwnerRepository;
import zw.co.lws.livestockwebservice.persistence.ownerpartnership.OwnerPartnershipRepository;
import zw.co.lws.livestockwebservice.persistence.partnership.PartnershipRepository;

@Configuration
public class PartnershipConfiguration {

    @Bean
    public PartnershipCreateService partnershipCreateService(PartnershipRepository partnershipRepository){
        return new PartnershipCreateServiceImpl(partnershipRepository);
    }

    @Bean
    public AssignPartnerService assignPartnerService(OwnerPartnershipRepository ownerPartnershipRepository, OwnerRepository ownerRepository,PartnershipRepository partnershipRepository){
        return  new AssignPartnerServiceImpl(partnershipRepository,ownerRepository,ownerPartnershipRepository);
    }

}
