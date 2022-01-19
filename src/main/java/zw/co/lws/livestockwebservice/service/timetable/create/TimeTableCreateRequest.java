package zw.co.lws.livestockwebservice.service.timetable.create;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import zw.co.lws.livestockwebservice.domain.enums.TaskStatus;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class TimeTableCreateRequest {
    @NotNull(message = "task name is required")
    private String taskName;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private TaskStatus taskStatus;
}
