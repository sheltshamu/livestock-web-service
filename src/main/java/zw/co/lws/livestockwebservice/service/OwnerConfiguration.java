package zw.co.lws.livestockwebservice.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zw.co.lws.livestockwebservice.persistence.owner.OwnerRepository;

@Configuration
public class OwnerConfiguration {
    @Bean
    public OwnerCreateService ownerCreateService(OwnerRepository ownerRepository){
        return new OwnerCreateServiceImpl(ownerRepository);
    }
    @Bean
    public OwnerUpdateService ownerUpdateService(OwnerRepository ownerRepository){
        return new OwnerUpdateServiceImpl(ownerRepository);
    }

    @Bean
    public FindOwnerService ownerService(OwnerRepository ownerRepository){
        return new FindOwnerServiceImpl(ownerRepository);
    }
}
