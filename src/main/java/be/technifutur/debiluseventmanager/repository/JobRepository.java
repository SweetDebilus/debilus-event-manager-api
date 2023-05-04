package be.technifutur.debiluseventmanager.repository;

import be.technifutur.debiluseventmanager.model.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
