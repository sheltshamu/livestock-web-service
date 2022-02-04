package zw.co.lws.livestockwebservice.service;

import zw.co.lws.livestockwebservice.domain.Venture;

public class VentureResponse {
    private final Venture venture;

    public VentureResponse(Venture venture) {
        this.venture = venture;
    }

    public Venture getPartnership() {
        return venture;
    }
}
