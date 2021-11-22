package zw.co.lws.livestockwebservice.service.cow;

import org.springframework.stereotype.Service;
import zw.co.lws.livestockwebservice.domain.Cow;
import zw.co.lws.livestockwebservice.domain.MedicationRecord;
import zw.co.lws.livestockwebservice.domain.Owner;
import zw.co.lws.livestockwebservice.persistence.CowRepository;
import zw.co.lws.livestockwebservice.persistence.MedicationRecordRepository;
import zw.co.lws.livestockwebservice.persistence.OwnerRepository;
import zw.co.lws.livestockwebservice.service.exceptions.CowNotFound;
import zw.co.lws.livestockwebservice.service.exceptions.OwnerNotFound;
import zw.co.lws.livestockwebservice.service.exceptions.RecordNotFoundException;

import java.util.Optional;

@Service
public class CowUpdateServiceImpl implements CowUpdateService{
    private final OwnerRepository ownerRepository;
    private final CowRepository cowRepository;
    private final MedicationRecordRepository medicationRecordRepository;

    public CowUpdateServiceImpl(OwnerRepository ownerRepository, CowRepository cowRepository, MedicationRecordRepository medicationRecordRepository) {
        this.ownerRepository = ownerRepository;
        this.cowRepository = cowRepository;
        this.medicationRecordRepository = medicationRecordRepository;
    }

    @Override
    public CowResponse update(CowUpdateRequest cowUpdateRequest) {
        Optional<Cow> existingCow = cowRepository.findByTagNumber(cowUpdateRequest.getTagNumber());
        if (!existingCow.isPresent()){
            throw new CowNotFound(cowUpdateRequest.getTagNumber());
        }
        //TODO to finish the update functionality

        return null;
    }
}
