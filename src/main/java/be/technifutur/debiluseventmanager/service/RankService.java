package be.technifutur.debiluseventmanager.service;

import be.technifutur.debiluseventmanager.model.dto.RankDTO;
import be.technifutur.debiluseventmanager.model.dto.RankUserDTO;
import be.technifutur.debiluseventmanager.model.form.RankForm;

import java.util.List;

public interface RankService {

    void createRank (RankForm rankForm);

    void updateRank (RankForm rankForm, long id);

    void deleteRank (Long id);

    RankUserDTO getRankById (Long id);

    List<RankUserDTO> getAllRanks ();
}
