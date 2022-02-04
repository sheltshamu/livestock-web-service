package zw.co.lws.livestockwebservice.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zw.co.lws.livestockwebservice.persistence.timetable.TimeTableRepository;

@Configuration
public class TimeTableConfiguration {
    @Bean
    public FindTimeTableService timeTableService(TimeTableRepository timeTableRepository){
        return new FindTimeTableServiceImpl(timeTableRepository);
    }

    @Bean
    public TimeTableCreateService timeTableCreateService(TimeTableRepository timeTableRepository){
        return new TimeTableCreateServiceImpl(timeTableRepository);
    }

    @Bean
    public TimeTableUpdateService timeTableUpdateService(TimeTableRepository timeTableRepository){
        return new TimeTableUpdateServiceImpl(timeTableRepository);
    }




}
