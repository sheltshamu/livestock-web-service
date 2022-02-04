package zw.co.lws.livestockwebservice.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
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
@Table(name = "equipment")
public class Equipment extends BaseEntity{
    @Column(length =80)
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column(unique = true)
    private String model;
    @Column(unique = true)
    private String serialNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateAquired;
    @Column(nullable = false)
    private Double purchasePrice;
    @Column(length = 200)
    private String description;

}
