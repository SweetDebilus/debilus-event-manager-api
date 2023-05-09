package be.technifutur.debiluseventmanager.service;

import be.technifutur.debiluseventmanager.model.dto.EventDTO;
import be.technifutur.debiluseventmanager.model.form.EventForm;

import java.util.List;

public interface EventService {

    void createEvent (EventForm eventForm);

    void updateEvent (EventForm eventForm, Long id);

    void deleteEvent (Long id);

    EventDTO getEventById (Long id);

    List<EventDTO> getAllEvents ();
}
