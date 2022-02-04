package zw.co.lws.livestockwebservice.api;

import zw.co.lws.livestockwebservice.commons.Type;
import zw.co.lws.livestockwebservice.domain.Venture;

import java.time.LocalDate;

public class VentureDto {
    private String name;
    private Type type;

    public VentureDto() {
    }
    public static VentureDto dataFromVenture(Venture venture){
        VentureDto ventureDto = new VentureDto();
        ventureDto.name= venture.getName();
        ventureDto.type=venture.getType();
        return ventureDto;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}
