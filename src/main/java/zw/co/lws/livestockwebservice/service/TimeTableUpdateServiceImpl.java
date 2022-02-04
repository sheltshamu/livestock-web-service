package zw.co.lws.livestockwebservice.service;

import zw.co.lws.livestockwebservice.domain.TimeTable;
import zw.co.lws.livestockwebservice.persistence.timetable.TimeTableRepository;
import zw.co.lws.livestockwebservice.service.exception.ResourceNotFoundException;

import java.time.LocalDateTime;

public class TimeTableUpdateServiceImpl implements TimeTableUpdateService{
    private final TimeTableRepository timeTableRepository;

    public TimeTableUpdateServiceImpl(TimeTableRepository timeTableRepository) {
        this.timeTableRepository = timeTableRepository;
    }

    @Override
    public TimeTableResponse update(TimeTableUpdateRequest timeTableUpdateRequest) {
        TimeTable timeTable = timeTableRepository.findById(timeTableUpdateRequest.getId())
                .orElseThrow(()->new ResourceNotFoundException("Timetable with id {0} was not found",timeTableUpdateRequest.getId()));
        timeTable.setDate(timeTableUpdateRequest.getDate());
        timeTable.setDescription(timeTableUpdateRequest.getDescription());
        timeTable.setTaskName(timeTableUpdateRequest.getTaskName());
        timeTable.setModifiedDate(LocalDateTime.now());
        timeTable.setTaskStatus(timeTableUpdateRequest.getTaskStatus());
        timeTableRepository.save(timeTable);
        return new TimeTableResponse(timeTable);
    }
}
