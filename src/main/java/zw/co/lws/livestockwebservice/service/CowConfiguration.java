package zw.co.lws.livestockwebservice.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zw.co.lws.livestockwebservice.persistence.cow.CowRepository;
import zw.co.lws.livestockwebservice.persistence.owner.OwnerRepository;

@Configuration
public class CowConfiguration {

    @Bean
    public CowCreateService cowCreateService(OwnerRepository ownerRepository, CowRepository cowRepository){
        return new CowCreateServiceImpl(ownerRepository,cowRepository);
    }

    @Bean
    public FindCowService cowService(CowRepository cowRepository, OwnerRepository ownerRepository){
        return new FindCowServiceImpl(cowRepository,ownerRepository);
    }

    @Bean
    public CowUpdateService cowUpdateService(CowRepository cowRepository, OwnerRepository ownerRepository){
        return new CowUpdateServiceImpl(cowRepository,ownerRepository);
    }
}
