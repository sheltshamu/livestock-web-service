package zw.co.lws.livestockwebservice.service;

@FunctionalInterface
public interface TimeTableCreateService {
    TimeTableResponse create(TimeTableCreateRequest timeTableCreateRequest);
}
