package zw.co.lws.livestockwebservice.persistence;

import org.springframework.stereotype.Repository;
import zw.co.lws.livestockwebservice.domain.Category;
import zw.co.lws.livestockwebservice.domain.Cow;

import java.util.List;
import java.util.Optional;

@Repository
public interface CowRepository extends BaseRepository<Cow>{
    Optional<Cow> findByTagNumber(String string);
    List<Cow> findCowsByCategory(Category category);
}
