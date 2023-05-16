package be.technifutur.debiluseventmanager.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthDTO {

    private String username;
    private String token;
    
}
