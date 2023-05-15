package be.technifutur.debiluseventmanager.repository;

import be.technifutur.debiluseventmanager.model.entity.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RankRepository extends JpaRepository<Rank, Long> {
    @Query("select r from Rank r where r.name = ?1")
    Rank findByName(String rank);


}
