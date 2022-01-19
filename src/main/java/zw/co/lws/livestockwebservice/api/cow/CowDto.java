package zw.co.lws.livestockwebservice.api.cow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import zw.co.lws.livestockwebservice.domain.*;
import zw.co.lws.livestockwebservice.domain.enums.Category;
import zw.co.lws.livestockwebservice.domain.enums.Gender;
import zw.co.lws.livestockwebservice.domain.enums.Type;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CowDto {
    private String tagNumber;
    private LocalDate dateOfBirth;
    private Type type;
    private Category category;
    private Gender gender;
    private String ownerName;

    public CowDto(Cow cow){
        this.category=cow.getCategory();
        this.dateOfBirth=cow.getDateOfBirth();
        this.gender=cow.getGender();
        this.type=cow.getType();
        this.ownerName=cow.getOwner().getFullName();
        this.tagNumber= cow.getTagNumber();
    }

    public static CowDto fromCowDto(Cow cow){
        CowDto cowDto = new CowDto();
        cowDto.setDateOfBirth(cow.getDateOfBirth());
        cowDto.setGender(cow.getGender());
        cowDto.setType(cow.getType());
        cowDto.setTagNumber(cow.getTagNumber());
        cowDto.setCategory(cow.getCategory());
        cowDto.setOwnerName(cow.getOwner().getFullName());
        return cowDto;
    }
}
