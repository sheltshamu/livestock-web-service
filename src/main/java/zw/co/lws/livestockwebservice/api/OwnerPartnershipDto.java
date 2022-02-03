package zw.co.lws.livestockwebservice.api;

import zw.co.lws.livestockwebservice.domain.OwnerPartnership;

public class OwnerPartnershipDto {
    private Long ownerId;
    private Long partnershipId;

    public static OwnerPartnershipDto dataFromOwnerPartnership(OwnerPartnership ownerPartnership){
        OwnerPartnershipDto ownerPartnershipDto = new OwnerPartnershipDto();
        ownerPartnershipDto.ownerId=ownerPartnership.getOwner().getId();
        ownerPartnershipDto.partnershipId=ownerPartnership.getPartnership().getId();
        return ownerPartnershipDto;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public Long getPartnershipId() {
        return partnershipId;
    }
}
