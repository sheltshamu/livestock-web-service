package zw.co.lws.livestockwebservice.service.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zw.co.lws.livestockwebservice.persistence.cow.CowRepository;
import zw.co.lws.livestockwebservice.persistence.medicalrecord.MedicationRepository;
import zw.co.lws.livestockwebservice.persistence.owner.OwnerRepository;
import zw.co.lws.livestockwebservice.persistence.timetable.TimeTableRepository;
import zw.co.lws.livestockwebservice.service.cow.create.CowCreateService;
import zw.co.lws.livestockwebservice.service.cow.create.CowCreateServiceImpl;
import zw.co.lws.livestockwebservice.service.cow.find.CowService;
import zw.co.lws.livestockwebservice.service.cow.find.CowServiceImpl;
import zw.co.lws.livestockwebservice.service.cow.update.CowUpdateService;
import zw.co.lws.livestockwebservice.service.cow.update.CowUpdateServiceImpl;
import zw.co.lws.livestockwebservice.service.medication.create.MedicationCreateService;
import zw.co.lws.livestockwebservice.service.medication.create.MedicationCreateServiceImpl;
import zw.co.lws.livestockwebservice.service.medication.find.MedicationService;
import zw.co.lws.livestockwebservice.service.medication.find.MedicationServiceImpl;
import zw.co.lws.livestockwebservice.service.medication.update.MedicationUpdateService;
import zw.co.lws.livestockwebservice.service.medication.update.MedicationUpdateServiceImpl;
import zw.co.lws.livestockwebservice.service.owner.create.OwnerCreateService;
import zw.co.lws.livestockwebservice.service.owner.create.OwnerCreateServiceImpl;
import zw.co.lws.livestockwebservice.service.owner.find.OwnerService;
import zw.co.lws.livestockwebservice.service.owner.find.OwnerServiceImpl;
import zw.co.lws.livestockwebservice.service.owner.update.OwnerUpdateService;
import zw.co.lws.livestockwebservice.service.owner.update.OwnerUpdateServiceImpl;
import zw.co.lws.livestockwebservice.service.timetable.find.TimeTableService;
import zw.co.lws.livestockwebservice.service.timetable.find.TimeTableServiceImpl;

@Configuration
public class ServiceConfiguration {
    @Bean
    public TimeTableService timeTableService(TimeTableRepository timeTableRepository){
        return new TimeTableServiceImpl(timeTableRepository);
    }

    @Bean
    public OwnerCreateService ownerCreateService(OwnerRepository ownerRepository){
        return new OwnerCreateServiceImpl(ownerRepository);
    }
    @Bean
    public OwnerUpdateService ownerUpdateService(OwnerRepository ownerRepository){
        return new OwnerUpdateServiceImpl(ownerRepository);
    }

    @Bean
    public OwnerService ownerService(OwnerRepository ownerRepository){
        return new OwnerServiceImpl(ownerRepository);
    }


    @Bean
    public CowCreateService cowCreateService(OwnerRepository ownerRepository,CowRepository cowRepository){
        return new CowCreateServiceImpl(ownerRepository,cowRepository);
    }

    @Bean
    public CowService cowService(CowRepository cowRepository,OwnerRepository ownerRepository){
        return new CowServiceImpl(cowRepository,ownerRepository);
    }

    @Bean
    public CowUpdateService cowUpdateService(CowRepository cowRepository,OwnerRepository ownerRepository){
        return new CowUpdateServiceImpl(cowRepository,ownerRepository);
    }

    @Bean
    public MedicationCreateService medicationCreateService(MedicationRepository medicationRepository,CowRepository cowRepository){
        return new MedicationCreateServiceImpl(medicationRepository,cowRepository);
    }

    @Bean
    public MedicationUpdateService medicationUpdateService(MedicationRepository medicationRepository, CowRepository cowRepository){
        return new MedicationUpdateServiceImpl(medicationRepository,cowRepository);
    }

    @Bean
    public MedicationService medicationRecordService(MedicationRepository medicationRepository){
        return new MedicationServiceImpl(medicationRepository);
    }
}
