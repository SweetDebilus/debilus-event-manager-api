package be.technifutur.debiluseventmanager.model.dto;

import java.util.List;

import be.technifutur.debiluseventmanager.model.entity.Rank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RankDTO {

        private String name;

        public static RankDTO from(Rank entity){
            if (entity == null) {
                return null;
            }
            return RankDTO.builder()
                    .name(entity.getName())
                    .build();
        }
}
