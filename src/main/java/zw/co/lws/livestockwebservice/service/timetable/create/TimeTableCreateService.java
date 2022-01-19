package zw.co.lws.livestockwebservice.service.timetable.create;

import zw.co.lws.livestockwebservice.service.timetable.TimeTableResponse;

@FunctionalInterface
public interface TimeTableCreateService {
    TimeTableResponse create(TimeTableCreateRequest timeTableCreateRequest);
}
