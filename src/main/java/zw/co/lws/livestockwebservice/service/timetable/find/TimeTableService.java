package zw.co.lws.livestockwebservice.service.timetable.find;

import zw.co.lws.livestockwebservice.domain.TaskStatus;
import zw.co.lws.livestockwebservice.service.timetable.TimeTableResponse;
import zw.co.lws.livestockwebservice.service.timetable.update.TimeTableUpdateRequest;

import java.time.LocalDate;
import java.util.List;

public interface TimeTableService {
    List<TimeTableResponse> findByDate(LocalDate date);
    List<TimeTableResponse>findAllByTaskStatus(TaskStatus taskStatus);
}
