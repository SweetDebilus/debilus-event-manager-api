package be.technifutur.debiluseventmanager.model.dto;

import java.time.LocalDate;
import be.technifutur.debiluseventmanager.model.entity.RegistrationHistory;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationHistoryDTO {

    private LocalDate date;

    public static RegistrationHistoryDTO from(RegistrationHistory entity) {
        if (entity == null) {
            return null;
        }
        return RegistrationHistoryDTO.builder()
                .date(entity.getDateOfRegistration())
                .build();
    }

}
