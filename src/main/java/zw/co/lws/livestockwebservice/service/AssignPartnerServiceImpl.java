package zw.co.lws.livestockwebservice.service;

import zw.co.lws.livestockwebservice.domain.Owner;
import zw.co.lws.livestockwebservice.domain.OwnerPartnership;
import zw.co.lws.livestockwebservice.domain.Partnership;
import zw.co.lws.livestockwebservice.persistence.owner.OwnerRepository;
import zw.co.lws.livestockwebservice.persistence.ownerpartnership.OwnerPartnershipRepository;
import zw.co.lws.livestockwebservice.persistence.partnership.PartnershipRepository;
import zw.co.lws.livestockwebservice.service.exception.ResourceNotFoundException;

public class AssignPartnerServiceImpl implements AssignPartnerService{
    private final PartnershipRepository partnershipRepository;
    private final OwnerRepository ownerRepository;
    private final OwnerPartnershipRepository ownerPartnershipRepository;

    public AssignPartnerServiceImpl(PartnershipRepository partnershipRepository, OwnerRepository ownerRepository, OwnerPartnershipRepository ownerPartnershipRepository) {
        this.partnershipRepository = partnershipRepository;
        this.ownerRepository = ownerRepository;
        this.ownerPartnershipRepository = ownerPartnershipRepository;
    }

    @Override
    public OwnerPartnerShipResponse assign(AssignPartnerRequest assignPartnerRequest) {
        Owner owner = ownerRepository.findById(assignPartnerRequest.getOwnerId())
                .orElseThrow(()-> new ResourceNotFoundException("Owner {0} not found", assignPartnerRequest.getOwnerId()));
        Partnership partnership = partnershipRepository.findById(assignPartnerRequest.getPartnershipId())
                .orElseThrow(()-> new ResourceNotFoundException("Partnership {0} not found", assignPartnerRequest.getPartnershipId()));
        OwnerPartnership ownerPartnership = new OwnerPartnership();
        ownerPartnership.setPartnership(partnership);
        ownerPartnership.setOwner(owner);
        //Send Notification to Owner
        //Todo Notify the member
        ownerPartnershipRepository.save(ownerPartnership);
        return new OwnerPartnerShipResponse(ownerPartnership);
    }
}
