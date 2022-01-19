package zw.co.lws.livestockwebservice.service.timetable.find;

import zw.co.lws.livestockwebservice.domain.TaskStatus;
import zw.co.lws.livestockwebservice.domain.TimeTable;
import zw.co.lws.livestockwebservice.persistence.timetable.TimeTableRepository;
import zw.co.lws.livestockwebservice.service.timetable.TimeTableResponse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FindTimeTableServiceImpl implements FindTimeTableService {
    private final TimeTableRepository timeTableRepository;

    public FindTimeTableServiceImpl(TimeTableRepository timeTableRepository) {
        this.timeTableRepository = timeTableRepository;
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
