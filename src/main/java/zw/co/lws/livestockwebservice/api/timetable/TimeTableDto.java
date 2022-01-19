package zw.co.lws.livestockwebservice.api.timetable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import zw.co.lws.livestockwebservice.domain.TaskStatus;
import zw.co.lws.livestockwebservice.domain.TimeTable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeTableDto {
    private String taskName;
   private String description;
    private LocalDate date;
    private TaskStatus taskStatus;

    public TimeTableDto(TimeTable timeTable){
        this.taskName=timeTable.getTaskName();
       this.description=timeTable.getDescription();
       this.date=timeTable.getDate();
      this.taskStatus=timeTable.getTaskStatus();
    }

    public static TimeTableDto of(TimeTable timeTable){
        TimeTableDto timeTableDto =new TimeTableDto();
        timeTableDto.taskName=timeTable.getTaskName();
       timeTableDto.description=timeTable.getDescription();
      timeTableDto.date=timeTable.getDate();
        timeTableDto.taskStatus=timeTable.getTaskStatus();
        return timeTableDto;
    }

    /*
    TODO find Task by Status
     */

}
