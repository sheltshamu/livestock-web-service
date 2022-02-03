package zw.co.lws.livestockwebservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@AllArgsConstructor
@Data
@Entity
@Table(name = "owner_partnership")
public class OwnerPartnership extends BaseEntity{
    public OwnerPartnership() {
    }
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    @ManyToOne
    @JoinColumn(name ="partnership_id")
    private Partnership partnership;

}
