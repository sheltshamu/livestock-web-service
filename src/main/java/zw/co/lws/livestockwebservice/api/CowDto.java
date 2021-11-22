package zw.co.lws.livestockwebservice.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import zw.co.lws.livestockwebservice.domain.*;

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
    private Owner owner;

    public static CowDto fromCowDto(Cow cow){
        CowDto cowDto = new CowDto();
        cowDto.setDateOfBirth(cow.getDateOfBirth());
        cowDto.setGender(cow.getGender());
        cowDto.setType(cow.getType());
        cowDto.setTagNumber(cow.getTagNumber());
        cowDto.setCategory(cow.getCategory());
        cowDto.setOwner(cow.getOwner());
        return cowDto;
    }
}
