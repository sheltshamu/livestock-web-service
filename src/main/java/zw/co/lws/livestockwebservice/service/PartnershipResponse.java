package zw.co.lws.livestockwebservice.service;

import zw.co.lws.livestockwebservice.domain.Partnership;

public class PartnershipResponse {
    private final Partnership partnership;

    public PartnershipResponse(Partnership partnership) {
        this.partnership = partnership;
    }

    public Partnership getPartnership() {
        return partnership;
    }
}
