package zw.co.lws.livestockwebservice.service;

public class AssignPartnerRequest {
    private Long partnershipId;
    private Long ownerId;

    public Long getPartnershipId() {
        return partnershipId;
    }

    public void setPartnershipId(Long partnershipId) {
        this.partnershipId = partnershipId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "AssignPartnerRequest{" +
                "partnershipId=" + partnershipId +
                ", ownerId=" + ownerId +
                '}';
    }
}
