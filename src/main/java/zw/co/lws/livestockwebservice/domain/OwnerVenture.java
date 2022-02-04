package zw.co.lws.livestockwebservice.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "owner_venture")
public class OwnerVenture extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    @ManyToOne
    @JoinColumn(name ="venture_id")
    private Venture venture;

}
