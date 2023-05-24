package be.technifutur.debiluseventmanager.repository;

import be.technifutur.debiluseventmanager.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    @Query("SELECT u FROM User u WHERE u.username = ?1")
    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.rank.name = ?1")
    List<User> findAllByRank(String rank);

    @Query("SELECT u FROM User u WHERE u.isActive = true ORDER BY u.rank.id ASC")
    List<User> findAllActiveOrderByRank();

}
