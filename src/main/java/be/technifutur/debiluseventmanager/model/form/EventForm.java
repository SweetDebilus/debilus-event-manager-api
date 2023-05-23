package be.technifutur.debiluseventmanager.model.form;

import be.technifutur.debiluseventmanager.model.entity.Event;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT")
    @NotNull
    private LocalDateTime beginDate;

    @FutureOrPresent
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT")
    @NotNull
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
