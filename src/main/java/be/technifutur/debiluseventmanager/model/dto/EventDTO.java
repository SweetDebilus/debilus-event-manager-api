package be.technifutur.debiluseventmanager.model.dto;

import be.technifutur.debiluseventmanager.model.entity.Event;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class EventDTO {

    private Long id;
    private String name;
    private String description;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private List<UserEventDTO> participants;
    private UserEventDTO organizer;
    private List<FeedbackDTO> feedbacks;
    private String status;

    public static EventDTO from(Event entity) {
        if (entity == null) {
            return null;
        }
        return EventDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .beginDate(entity.getBeginDate())
                .endDate(entity.getEndDate())
                .participants(entity.getParticipants().stream().map(UserEventDTO::from).toList())
                .organizer(UserEventDTO.from(entity.getOrganizer()))
                .feedbacks(entity.getFeedbacks().stream().map(FeedbackDTO::from).toList())
                .status("")
                .build();
    }
}
