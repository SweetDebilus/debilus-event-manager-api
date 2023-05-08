package be.technifutur.debiluseventmanager.service;

import be.technifutur.debiluseventmanager.model.dto.FeedbackDTO;

import java.util.List;

public interface FeedbackService {

        void createFeedback ();

        FeedbackDTO getFeedbackById ();

        List<FeedbackDTO> getAllFeedbacks ();
}
