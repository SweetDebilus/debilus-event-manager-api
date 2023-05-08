package be.technifutur.debiluseventmanager.service;

import be.technifutur.debiluseventmanager.model.dto.RankDTO;

import java.util.List;

public interface RankService {

    void createRank ();

    void updateRank ();

    void deleteRank ();

    RankDTO getRankById ();

    List<RankDTO> getAllRanks ();
}
