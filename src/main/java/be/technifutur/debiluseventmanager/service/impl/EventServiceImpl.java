package be.technifutur.debiluseventmanager.service.impl;

import be.technifutur.debiluseventmanager.model.dto.EventDTO;
import be.technifutur.debiluseventmanager.model.entity.Event;
import be.technifutur.debiluseventmanager.model.entity.User;
import be.technifutur.debiluseventmanager.model.form.EventForm;
import be.technifutur.debiluseventmanager.repository.EventRepository;
import be.technifutur.debiluseventmanager.repository.UserRepository;
import be.technifutur.debiluseventmanager.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService{

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public EventServiceImpl(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createEvent(EventForm eventForm) {
        Event event = EventForm.toEntity(eventForm);
        if (!eventForm.getBeginDate().isBefore(eventForm.getEndDate())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Begin date must be before end date");
        }
        Optional<User> organizer = userRepository.findByUsername(eventForm.getOrganizer());
        System.out.println(organizer.toString());
        if (organizer.isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Organizer not found");
        event.setOrganizer(organizer.get());
        eventRepository.save(event);
    }

    @Override
    public void updateEvent(EventForm eventForm, Long id) {
        Event eventToUpdate = eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
        if (eventForm.getName() != null) {
            eventToUpdate.setName(eventForm.getName());
            eventToUpdate.setDescription(eventForm.getDescription());
            eventToUpdate.setBeginDate(eventForm.getBeginDate());
            eventToUpdate.setEndDate(eventForm.getEndDate());
            if (eventForm.getOrganizer() != null) {
                eventRepository.save(eventToUpdate);
            }
            else {
                throw new RuntimeException("Organizer not found");
            }
        }
    }

    @Override
    public void deleteEvent(Long id) {
        Event eventToDelete = eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
        eventRepository.delete(eventToDelete);
    }

    @Override
    public EventDTO getEventById(Long id) {
        return eventRepository.findById(id).map(EventDTO::from).orElseThrow(() -> new RuntimeException("Event not found"));
    }

    @Override
    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll().stream().map(EventDTO::from).toList();
    }
}
