package zw.co.lws.livestockwebservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import zw.co.lws.livestockwebservice.commons.Status;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@Entity
@Table(name = "partnership")
public class Partnership extends BaseEntity{
    public Partnership() {
    }
    @Column(unique = true,length = 35)
    private String name;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateFormed;
    @Enumerated(EnumType.STRING)
    private Status status;

}
