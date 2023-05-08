package be.technifutur.debiluseventmanager.service;

import be.technifutur.debiluseventmanager.model.dto.ConflictReportDTO;

import java.util.List;

public interface ConflictReportService {

    void createConflictReport ();

    void updateConflictReport ();

    void deleteConflictReport ();

    ConflictReportDTO getConflictReportById ();

    List<ConflictReportDTO> getAllConflictReports ();
}
