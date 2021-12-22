package zw.co.lws.livestockwebservice.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    @Column(name = "date_created")
    private LocalDateTime createdDate;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    @Column(name = "date_modified")
    private LocalDateTime modifiedDate;

}
