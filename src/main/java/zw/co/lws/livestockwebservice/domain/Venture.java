package zw.co.lws.livestockwebservice.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import zw.co.lws.livestockwebservice.commons.Status;
import zw.co.lws.livestockwebservice.commons.Type;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "venture")
public class Venture extends BaseEntity{
    @Column(unique = true,length = 35)
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;

}
