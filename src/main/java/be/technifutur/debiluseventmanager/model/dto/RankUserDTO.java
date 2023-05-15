package be.technifutur.debiluseventmanager.model.dto;

import be.technifutur.debiluseventmanager.model.entity.Rank;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RankUserDTO {

    private String name;
    private List<UserRankDTO> users;

    public static RankUserDTO from(Rank entity){
        if (entity == null) {
            return null;
        }
        return RankUserDTO.builder()
                .name(entity.getName())
                .users(entity.getUsers().stream().map(UserRankDTO::from).toList())
                .build();
    }
}
