package zw.co.lws.livestockwebservice.persistence.cow;

import org.springframework.stereotype.Repository;
import zw.co.lws.livestockwebservice.domain.enums.Category;
import zw.co.lws.livestockwebservice.domain.Cow;
import zw.co.lws.livestockwebservice.domain.enums.Status;
import zw.co.lws.livestockwebservice.persistence.base.BaseRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CowRepository extends BaseRepository<Cow> {
    Optional<Cow> findByTagNumber(String string);
    List<Cow> findCowsByCategory(Category category);
    List<Cow> findCowsByStatus(Status status);
}
