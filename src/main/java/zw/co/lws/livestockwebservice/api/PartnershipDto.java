package zw.co.lws.livestockwebservice.api;

import zw.co.lws.livestockwebservice.domain.Partnership;

import java.time.LocalDate;

public class PartnershipDto {
    private String name;
    private LocalDate dateFormed;

    public PartnershipDto() {
    }
    public static PartnershipDto dataFromPartnership(Partnership partnership){
        PartnershipDto partnershipDto = new PartnershipDto();
        partnershipDto.name= partnership.getName();
        partnershipDto.dateFormed = partnership.getDateFormed();
        return  partnershipDto;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateFormed() {
        return dateFormed;
    }

}
