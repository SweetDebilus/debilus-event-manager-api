package be.technifutur.debiluseventmanager.model.dto;

import java.util.List;

import be.technifutur.debiluseventmanager.model.entity.Race;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RaceDTO {

    private String name;

    public static RaceDTO from(Race entity){
        if (entity == null) {
            return null;
        }
        return RaceDTO.builder()
                .name(entity.getName())
                .build();
    }

}
