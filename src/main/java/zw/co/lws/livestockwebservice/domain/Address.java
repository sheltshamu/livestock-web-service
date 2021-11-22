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
    @Column(name = "house_number",length = 80)
    private String houseNo;
    @Column(length = 80)
    private String suburb;
    @Column(length = 80)
    private String city;
}
