package be.technifutur.debiluseventmanager.model.dto;

import be.technifutur.debiluseventmanager.model.entity.ConflictReport;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ConflictReportDTO {

    private String description;
    private UserDTO author;
    private List<UserDTO> accused;
    private String message;

    public static ConflictReportDTO from(ConflictReport entity) {
        if (entity == null) {
            return null;
        }
        return ConflictReportDTO.builder()
                .author(UserDTO.from(entity.getAuthor()))
                .accused(entity.getAccused().stream().map(UserDTO::from).toList())
                .message(entity.getMessage())
                .build();
    }
}
