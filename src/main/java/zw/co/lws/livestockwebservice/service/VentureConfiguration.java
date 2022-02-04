package zw.co.lws.livestockwebservice.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zw.co.lws.livestockwebservice.persistence.owner.OwnerRepository;
import zw.co.lws.livestockwebservice.persistence.ownerpartnership.OwnerVentureRepository;
import zw.co.lws.livestockwebservice.persistence.venture.VentureRepository;

@Configuration
public class VentureConfiguration {

    @Bean
    public VentureCreateService partnershipCreateService(VentureRepository ventureRepository){
        return new VentureCreateServiceImpl(ventureRepository);
    }

}
