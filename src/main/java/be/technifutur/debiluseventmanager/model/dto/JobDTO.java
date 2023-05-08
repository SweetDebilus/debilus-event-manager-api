package be.technifutur.debiluseventmanager.model.dto;

import java.util.List;
import be.technifutur.debiluseventmanager.model.entity.Job;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobDTO {

        private String name;

        public static JobDTO from(Job entity){
            if (entity == null) {
                return null;
            }
            return JobDTO.builder()
                    .name(entity.getName())
                    .build();
        }
}
