package zw.co.lws.livestockwebservice.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Embeddable
public class Address{
    @Column(length = 80)
    private String addressLine1;
    @Column(length = 80)
    private String addressLine2;
    @Column(length = 80)
    private String addressLine3;

}
