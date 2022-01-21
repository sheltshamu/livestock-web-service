package zw.co.lws.livestockwebservice.service.medication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zw.co.lws.livestockwebservice.persistence.cow.CowRepository;
import zw.co.lws.livestockwebservice.persistence.medication.MedicationRepository;
import zw.co.lws.livestockwebservice.service.medication.create.MedicationCreateService;
import zw.co.lws.livestockwebservice.service.medication.create.MedicationCreateServiceImpl;
import zw.co.lws.livestockwebservice.service.medication.find.FindMedicationService;
import zw.co.lws.livestockwebservice.service.medication.find.FindMedicationServiceImpl;
import zw.co.lws.livestockwebservice.service.medication.update.MedicationUpdateService;
import zw.co.lws.livestockwebservice.service.medication.update.MedicationUpdateServiceImpl;

@Configuration
public class MedicationConfiguration {
    @Bean
    public MedicationCreateService medicationCreateService(MedicationRepository medicationRepository, CowRepository cowRepository){
        return new MedicationCreateServiceImpl(medicationRepository,cowRepository);
    }

    @Bean
    public MedicationUpdateService medicationUpdateService(MedicationRepository medicationRepository, CowRepository cowRepository){
        return new MedicationUpdateServiceImpl(medicationRepository,cowRepository);
    }

    @Bean
    public FindMedicationService medicationRecordService(MedicationRepository medicationRepository){
        return new FindMedicationServiceImpl(medicationRepository);
    }
}
