package be.technifutur.debiluseventmanager.service;

import be.technifutur.debiluseventmanager.model.dto.RaceDTO;

import java.util.List;

public interface RaceService {

    void createRace ();

    void updateRace ();

    void deleteRace ();

    RaceDTO getRaceById ();

    List<RaceDTO> getAllRaces ();
}
