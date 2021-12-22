package zw.co.lws.livestockwebservice.service.timetable;

import zw.co.lws.livestockwebservice.domain.TaskStatus;

import java.time.LocalDate;
import java.util.List;

public interface TimeTableService {
    TimeTableResponse create(TimeTableRequest timeTableRequest);
    TimeTableResponse update(TimeTableUpdateRequest timeTableUpdateRequest);
    List<TimeTableResponse> findByDate(LocalDate date);
    List<TimeTableResponse>findAllByTaskStatus(TaskStatus taskStatus);
}
