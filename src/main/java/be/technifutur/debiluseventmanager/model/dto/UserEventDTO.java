package be.technifutur.debiluseventmanager.model.dto;

import be.technifutur.debiluseventmanager.model.entity.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEventDTO {

    private String username;
    private String characterName;
    private String characterId;

    public static UserEventDTO from(User entity) {
        if (entity == null) {
            return null;
        }
        return UserEventDTO.builder()
                .username(entity.getUsername())
                .characterName(entity.getCharacterName())
                .characterId(entity.getCharacterId())
                .build();
    }
}
