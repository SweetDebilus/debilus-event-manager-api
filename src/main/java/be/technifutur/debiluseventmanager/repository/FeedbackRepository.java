package be.technifutur.debiluseventmanager.repository;

import be.technifutur.debiluseventmanager.model.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
