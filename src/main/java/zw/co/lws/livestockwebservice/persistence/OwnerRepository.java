package zw.co.lws.livestockwebservice.persistence;

import org.springframework.stereotype.Repository;
import zw.co.lws.livestockwebservice.domain.Owner;
@Repository
public interface OwnerRepository extends BaseRepository<Owner>{
    Owner findOwnerByContactDetails_Email(String email);
    Owner findOwnerByContactDetails_MobileNumber(String mobileNumber);
}
