package be.technifutur.debiluseventmanager.service;

import be.technifutur.debiluseventmanager.model.dto.RegistrationHistoryDTO;

import java.util.List;

public interface RegistrationHistoryService {

    RegistrationHistoryDTO getRegistrationHistoryById (Long id);

    List<RegistrationHistoryDTO> getRegistrationHistoryByUserId (Long id);


}
