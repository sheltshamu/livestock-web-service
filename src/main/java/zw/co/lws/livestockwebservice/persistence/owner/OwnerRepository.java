package zw.co.lws.livestockwebservice.persistence.owner;

import org.springframework.stereotype.Repository;
import zw.co.lws.livestockwebservice.domain.Owner;
import zw.co.lws.livestockwebservice.persistence.base.BaseRepository;

@Repository
public interface OwnerRepository extends BaseRepository<Owner> {
    Owner findOwnerByContactDetails_Email(String email);
    Owner findOwnerByContactDetails_MobileNumber(String mobileNumber);
}
