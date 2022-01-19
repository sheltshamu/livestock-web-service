package zw.co.lws.livestockwebservice.service.timetable.update;

import zw.co.lws.livestockwebservice.service.timetable.TimeTableResponse;

@FunctionalInterface
public interface TimeTableUpdateService {
    TimeTableResponse update(TimeTableUpdateRequest timeTableUpdateRequest);
}
