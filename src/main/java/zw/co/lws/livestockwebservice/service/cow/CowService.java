package zw.co.lws.livestockwebservice.service.cow;

import org.springframework.data.domain.Page;
import zw.co.lws.livestockwebservice.domain.Category;
import zw.co.lws.livestockwebservice.domain.Cow;
import zw.co.lws.livestockwebservice.service.exceptions.OwnerNotFound;

import java.util.List;

public interface CowService {
    CowResponse create(CowRequest cowRequest);
    CowResponse update(CowUpdateRequest cowUpdateRequest);
    CowResponse findByTagNumber(String tagNumber);
}
