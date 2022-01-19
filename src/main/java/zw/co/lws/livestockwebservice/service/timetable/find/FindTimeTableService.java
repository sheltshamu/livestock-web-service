package zw.co.lws.livestockwebservice.service.timetable.find;

import zw.co.lws.livestockwebservice.domain.TaskStatus;
import zw.co.lws.livestockwebservice.service.timetable.TimeTableResponse;

import java.time.LocalDate;
import java.util.List;

public interface FindTimeTableService {
    List<TimeTableResponse> findByDate(LocalDate date);
    List<TimeTableResponse>findAllByTaskStatus(TaskStatus taskStatus);
}
