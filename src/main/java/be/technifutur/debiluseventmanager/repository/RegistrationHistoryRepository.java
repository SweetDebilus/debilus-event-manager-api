package be.technifutur.debiluseventmanager.repository;

import be.technifutur.debiluseventmanager.model.entity.RegistrationHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationHistoryRepository extends JpaRepository<RegistrationHistory, Long> {
}
