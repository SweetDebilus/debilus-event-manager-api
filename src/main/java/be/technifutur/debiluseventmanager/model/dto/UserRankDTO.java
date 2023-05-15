package be.technifutur.debiluseventmanager.model.dto;

import be.technifutur.debiluseventmanager.model.entity.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserRankDTO {

    private String username;

    public static UserRankDTO from(User entity){
        if (entity == null) {
            return null;
        }
        return UserRankDTO.builder()
                .username(entity.getUsername())
                .build();
    }
}
