package zw.co.lws.livestockwebservice.service.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zw.co.lws.livestockwebservice.persistence.cow.CowRepository;
import zw.co.lws.livestockwebservice.persistence.medicalrecord.MedicationRecordRepository;
import zw.co.lws.livestockwebservice.persistence.owner.OwnerRepository;
import zw.co.lws.livestockwebservice.persistence.timetable.TimeTableRepository;
import zw.co.lws.livestockwebservice.service.cow.CowService;
import zw.co.lws.livestockwebservice.service.cow.CowServiceImpl;
import zw.co.lws.livestockwebservice.service.medication.MedicationRecordService;
import zw.co.lws.livestockwebservice.service.medication.MedicationRecordServiceImpl;
import zw.co.lws.livestockwebservice.service.owner.OwnerService;
import zw.co.lws.livestockwebservice.service.owner.OwnerServiceImpl;
import zw.co.lws.livestockwebservice.service.timetable.TimeTableService;
import zw.co.lws.livestockwebservice.service.timetable.TimeTableServiceImpl;

@Configuration
public class ServiceConfiguration {
    @Bean
    public CowService cowService(CowRepository cowRepository,
                                 OwnerRepository ownerRepository,MedicationRecordRepository medicationRecordRepository){
        return new CowServiceImpl(cowRepository,ownerRepository,medicationRecordRepository);
    }
    @Bean
    public TimeTableService timeTableService(TimeTableRepository timeTableRepository){
        return new TimeTableServiceImpl(timeTableRepository);
    }
    @Bean
    public OwnerService ownerService(OwnerRepository ownerRepository){
        return new OwnerServiceImpl(ownerRepository);
    }
    @Bean
    public MedicationRecordService medicationRecordService(MedicationRecordRepository medicationRecordRepository,
                                                           CowRepository cowRepository,
                                                           CowService cowService){
        return new MedicationRecordServiceImpl(medicationRecordRepository,cowRepository,cowService);
    }
}
