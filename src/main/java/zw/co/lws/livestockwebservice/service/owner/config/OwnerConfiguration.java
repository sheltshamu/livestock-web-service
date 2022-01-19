package zw.co.lws.livestockwebservice.service.owner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zw.co.lws.livestockwebservice.persistence.owner.OwnerRepository;
import zw.co.lws.livestockwebservice.service.owner.create.OwnerCreateService;
import zw.co.lws.livestockwebservice.service.owner.create.OwnerCreateServiceImpl;
import zw.co.lws.livestockwebservice.service.owner.find.FindOwnerService;
import zw.co.lws.livestockwebservice.service.owner.find.FindOwnerServiceImpl;
import zw.co.lws.livestockwebservice.service.owner.update.OwnerUpdateService;
import zw.co.lws.livestockwebservice.service.owner.update.OwnerUpdateServiceImpl;

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
