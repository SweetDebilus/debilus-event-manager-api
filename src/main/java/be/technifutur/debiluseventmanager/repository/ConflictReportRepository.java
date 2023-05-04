package be.technifutur.debiluseventmanager.repository;

import be.technifutur.debiluseventmanager.model.entity.ConflictReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConflictReportRepository extends JpaRepository<ConflictReport, Long> {
}
