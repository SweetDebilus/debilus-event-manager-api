package be.technifutur.debiluseventmanager.repository;

import be.technifutur.debiluseventmanager.model.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceRepository extends JpaRepository<Race, Long> {
}
