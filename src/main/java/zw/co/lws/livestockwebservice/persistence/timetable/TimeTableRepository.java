package zw.co.lws.livestockwebservice.persistence.timetable;

import org.springframework.stereotype.Repository;
import zw.co.lws.livestockwebservice.domain.enums.TaskStatus;
import zw.co.lws.livestockwebservice.domain.TimeTable;
import zw.co.lws.livestockwebservice.persistence.base.BaseRepository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TimeTableRepository extends BaseRepository<TimeTable> {
    List<TimeTable> findTimeTablesByDate(LocalDate date);
    List<TimeTable> findTimeTablesByTaskStatus(TaskStatus taskStatus);
}
