package be.technifutur.debiluseventmanager.repository;

import be.technifutur.debiluseventmanager.model.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
