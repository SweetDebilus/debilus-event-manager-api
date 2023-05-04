package be.technifutur.debiluseventmanager.repository;

import be.technifutur.debiluseventmanager.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
