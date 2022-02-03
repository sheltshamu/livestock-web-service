package zw.co.lws.livestockwebservice.service;

import zw.co.lws.livestockwebservice.domain.OwnerPartnership;

public class OwnerPartnerShipResponse {
    private final OwnerPartnership ownerPartnership;

    public OwnerPartnerShipResponse(OwnerPartnership ownerPartnership) {
        this.ownerPartnership = ownerPartnership;
    }

    public OwnerPartnership getOwnerPartnership() {
        return ownerPartnership;
    }
}
