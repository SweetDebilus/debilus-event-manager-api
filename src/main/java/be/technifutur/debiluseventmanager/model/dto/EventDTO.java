package be.technifutur.debiluseventmanager.model.dto;

import be.technifutur.debiluseventmanager.model.entity.Event;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class EventDTO {

    private String name;
    private String description;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private List<UserDTO> participants;
    private UserDTO organizer;
    private List<FeedbackDTO> feedbacks;

    public static EventDTO from(Event entity) {
        if (entity == null) {
            return null;
        }
        return EventDTO.builder()
                .name(entity.getName())
                .description(entity.getDescription())
                .beginDate(entity.getBeginDate())
                .endDate(entity.getEndDate())
                .participants(entity.getParticipants().stream().map(UserDTO::from).toList())
                .organizer(UserDTO.from(entity.getOrganizer()))
                .feedbacks(entity.getFeedbacks().stream().map(FeedbackDTO::from).toList())
                .build();
    }
}
