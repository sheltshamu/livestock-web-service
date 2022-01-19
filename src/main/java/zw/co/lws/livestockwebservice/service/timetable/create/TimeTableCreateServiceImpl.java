package zw.co.lws.livestockwebservice.service.timetable.create;

import zw.co.lws.livestockwebservice.domain.TimeTable;
import zw.co.lws.livestockwebservice.persistence.timetable.TimeTableRepository;
import zw.co.lws.livestockwebservice.service.timetable.TimeTableResponse;

import java.time.LocalDateTime;

public class TimeTableCreateServiceImpl implements TimeTableCreateService{

    private final TimeTableRepository timeTableRepository;

    public TimeTableCreateServiceImpl(TimeTableRepository timeTableRepository) {
        this.timeTableRepository = timeTableRepository;
    }

    @Override
    public TimeTableResponse create(TimeTableCreateRequest timeTableCreateRequest) {
        TimeTable timeTable = new TimeTable();
        timeTable.setCreatedDate(LocalDateTime.now());
        timeTable.setModifiedDate(LocalDateTime.now());
        timeTable.setDate(timeTableCreateRequest.getDate());
        timeTable.setDescription(timeTableCreateRequest.getDescription());
        timeTable.setTaskName(timeTableCreateRequest.getTaskName());
        timeTable.setTaskStatus(timeTableCreateRequest.getTaskStatus());
        timeTableRepository.save(timeTable);
        return new TimeTableResponse(timeTable);
    }
}
