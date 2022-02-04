package zw.co.lws.livestockwebservice.service;

import lombok.Getter;
import zw.co.lws.livestockwebservice.domain.Owner;

@Getter
public class OwnerResponse {
    private final Owner owner;
    public OwnerResponse(Owner owner) {
        this.owner = owner;
    }
}
