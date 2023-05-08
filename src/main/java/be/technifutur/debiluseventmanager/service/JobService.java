package be.technifutur.debiluseventmanager.service;

import be.technifutur.debiluseventmanager.model.dto.JobDTO;

import java.util.List;

public interface JobService {

    void createJob ();

    void updateJob ();

    void deleteJob ();

    JobDTO getJobById ();

    List<JobDTO> getAllJobs ();
}
