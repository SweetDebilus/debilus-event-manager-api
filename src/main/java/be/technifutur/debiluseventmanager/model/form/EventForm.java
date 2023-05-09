package be.technifutur.debiluseventmanager.model.form;

import be.technifutur.debiluseventmanager.model.entity.Event;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EventForm {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @FutureOrPresent
    private LocalDateTime beginDate;

    @FutureOrPresent
    private LocalDateTime endDate;

    @NotBlank
    private String organizer;

    public static Event toEntity(EventForm eventForm) {
        Event event = new Event();
        event.setName(eventForm.getName());
        event.setDescription(eventForm.getDescription());
        event.setBeginDate(eventForm.getBeginDate());
        event.setEndDate(eventForm.getEndDate());
        return event;
    }
}
