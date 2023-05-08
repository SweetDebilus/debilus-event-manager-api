package be.technifutur.debiluseventmanager.model.dto;

import be.technifutur.debiluseventmanager.model.entity.Event;
import be.technifutur.debiluseventmanager.model.entity.Feedback;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FeedbackDTO {

    private String user;
    private String event;
    private String message;
    private int rating;

    public static FeedbackDTO from(Feedback entity) {
        if (entity == null) {
            return null;
        }
        return FeedbackDTO.builder()
                .user(UserDTO.from(entity.getUser()).getUsername())
                .event(EventDTO.from(entity.getEvent()).getName())
                .message(entity.getMessage())
                .rating(entity.getRating())
                .build();
    }
}
