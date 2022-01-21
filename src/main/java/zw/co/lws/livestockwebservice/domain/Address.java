package zw.co.lws.livestockwebservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address{
    @Column(length = 80)
    private String addressLine1;
    @Column(length = 80)
    private String addressLine2;
    @Column(length = 80)
    private String addressLine3;
}
