package zw.co.lws.livestockwebservice.service.cow;

import lombok.Getter;
import zw.co.lws.livestockwebservice.domain.Cow;
@Getter
public class CowResponse {
    private final Cow cow;

    public CowResponse(Cow cow) {
        this.cow = cow;
    }
}
