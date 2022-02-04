package zw.co.lws.livestockwebservice.service;

import zw.co.lws.livestockwebservice.domain.enums.TaskStatus;

import java.time.LocalDate;
import java.util.List;

public interface FindTimeTableService {
    List<TimeTableResponse> findByDate(LocalDate date);
    List<TimeTableResponse>findAllByTaskStatus(TaskStatus taskStatus);
}
