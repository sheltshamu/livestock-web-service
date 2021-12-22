package zw.co.lws.livestockwebservice.service.timetable;

import lombok.Getter;
import zw.co.lws.livestockwebservice.domain.TimeTable;

@Getter
public class TimeTableResponse {
    private final TimeTable timeTable;

    public TimeTableResponse(TimeTable timeTable) {
        this.timeTable = timeTable;
    }
}
