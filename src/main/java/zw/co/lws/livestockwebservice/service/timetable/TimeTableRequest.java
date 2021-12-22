package zw.co.lws.livestockwebservice.service.timetable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import zw.co.lws.livestockwebservice.domain.TaskStatus;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class TimeTableRequest {
    @NotNull(message = "task name is required")
    private String taskName;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private TaskStatus taskStatus;
}
