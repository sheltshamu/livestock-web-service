package zw.co.lws.livestockwebservice.service.timetable;

import org.springframework.stereotype.Service;
import zw.co.lws.livestockwebservice.domain.TaskStatus;
import zw.co.lws.livestockwebservice.domain.TimeTable;
import zw.co.lws.livestockwebservice.persistence.timetable.TimeTableRepository;
import zw.co.lws.livestockwebservice.service.exceptions.ResourceNotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TimeTableServiceImpl implements TimeTableService{
    private final TimeTableRepository timeTableRepository;

    public TimeTableServiceImpl(TimeTableRepository timeTableRepository) {
        this.timeTableRepository = timeTableRepository;
    }

    @Override
    public TimeTableResponse create(TimeTableRequest timeTableRequest) {
        TimeTable timeTable = new TimeTable();
        timeTable.setCreatedDate(LocalDateTime.now());
        timeTable.setModifiedDate(LocalDateTime.now());
        timeTable.setDate(timeTableRequest.getDate());
        timeTable.setDescription(timeTableRequest.getDescription());
        timeTable.setTaskName(timeTableRequest.getTaskName());
        timeTable.setTaskStatus(timeTableRequest.getTaskStatus());
        timeTableRepository.save(timeTable);
        return new TimeTableResponse(timeTable);
    }

    @Override
    public TimeTableResponse update(TimeTableUpdateRequest timeTableUpdateRequest) {
        Optional<TimeTable> existingTimeTable = timeTableRepository.findById(timeTableUpdateRequest.getId());
        if (!existingTimeTable.isPresent()) {
            throw new ResourceNotFoundException("Timetable with id {0} was not found",timeTableUpdateRequest.getId());
        }
        TimeTable timeTable = existingTimeTable.get();
        timeTable.setDate(timeTableUpdateRequest.getDate());
        timeTable.setDescription(timeTableUpdateRequest.getDescription());
        timeTable.setTaskName(timeTableUpdateRequest.getTaskName());
        timeTable.setModifiedDate(LocalDateTime.now());
        timeTable.setTaskStatus(timeTableUpdateRequest.getTaskStatus());
        timeTableRepository.save(timeTable);
        return new TimeTableResponse(timeTable);
    }

    @Override
    public List<TimeTableResponse> findByDate(LocalDate date) {
        List<TimeTable> timeTableList =timeTableRepository.findTimeTablesByDate(date);
        List<TimeTableResponse> timeTableResponseList = new ArrayList<>();
        timeTableList.stream().forEach(timeTable -> timeTableResponseList.add(new TimeTableResponse(timeTable)));
        return timeTableResponseList;
    }

    @Override
    public List<TimeTableResponse> findAllByTaskStatus(TaskStatus taskStatus) {
        List<TimeTable> timeTableList = timeTableRepository.findTimeTablesByTaskStatus(taskStatus);
        List<TimeTableResponse> timeTableResponseList = new ArrayList<>();
        timeTableList.stream().forEach(timeTable -> timeTableResponseList.add(new TimeTableResponse(timeTable)));
        return timeTableResponseList;
    }
}
