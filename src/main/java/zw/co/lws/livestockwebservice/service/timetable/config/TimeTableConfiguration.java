package zw.co.lws.livestockwebservice.service.timetable.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zw.co.lws.livestockwebservice.persistence.timetable.TimeTableRepository;
import zw.co.lws.livestockwebservice.service.timetable.create.TimeTableCreateService;
import zw.co.lws.livestockwebservice.service.timetable.create.TimeTableCreateServiceImpl;
import zw.co.lws.livestockwebservice.service.timetable.find.FindTimeTableService;
import zw.co.lws.livestockwebservice.service.timetable.find.FindTimeTableServiceImpl;
import zw.co.lws.livestockwebservice.service.timetable.update.TimeTableUpdateService;
import zw.co.lws.livestockwebservice.service.timetable.update.TimeTableUpdateServiceImpl;

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
