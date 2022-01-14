package zw.co.lws.livestockwebservice.persistence.owner;

import org.springframework.stereotype.Repository;
import zw.co.lws.livestockwebservice.domain.Owner;
import zw.co.lws.livestockwebservice.persistence.base.BaseRepository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends BaseRepository<Owner> {
    Optional<Owner> findOwnerByContactDetails_Email(String email);
    Optional<Owner> findOwnerByContactDetails_MobileNumber(String mobileNumber);
}
