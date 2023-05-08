package be.technifutur.debiluseventmanager.service;

import be.technifutur.debiluseventmanager.model.dto.EventDTO;

import java.util.List;

public interface EventService {

    void createEvent ();

    void updateEvent ();

    void deleteEvent ();

    EventDTO getEventById ();

    List<EventDTO> getAllEvents ();
}
