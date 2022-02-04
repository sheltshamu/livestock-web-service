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
@Table(name = "venture_equipment")
public class VentureEquipment extends BaseEntity{
    @ManyToOne
    @JoinColumn(name="venture_id")
    private Venture venture;
    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;
}
