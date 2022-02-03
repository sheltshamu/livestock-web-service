package zw.co.lws.livestockwebservice.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import zw.co.lws.livestockwebservice.domain.enums.TaskStatus;

import javax.persistence.*;
import java.time.LocalDate;
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "time_table")
public class TimeTable extends BaseEntity{
    public TimeTable(){

    }

    @Column(name = "task_name",length = 80)
    private String taskName;

    @Column(length = 200)
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(name ="task_status",nullable = false,length = 100)
    private TaskStatus taskStatus;

}
