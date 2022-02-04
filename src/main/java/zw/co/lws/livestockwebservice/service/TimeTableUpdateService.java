package zw.co.lws.livestockwebservice.service;

@FunctionalInterface
public interface TimeTableUpdateService {
    TimeTableResponse update(TimeTableUpdateRequest timeTableUpdateRequest);
}
