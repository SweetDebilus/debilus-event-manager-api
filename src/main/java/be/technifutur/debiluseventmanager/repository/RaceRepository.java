package be.technifutur.debiluseventmanager.repository;

import be.technifutur.debiluseventmanager.model.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RaceRepository extends JpaRepository<Race, Long> {
    @Query("select r from Race r where r.name = ?1")
    Race findByName(String race);
}
