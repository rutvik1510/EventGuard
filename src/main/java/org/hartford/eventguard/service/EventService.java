package org.hartford.eventguard.service;



import org.hartford.eventguard.dto.EventRequest;
import org.hartford.eventguard.entity.Event;
import org.hartford.eventguard.entity.User;
import org.hartford.eventguard.exception.ResourceNotFoundException;
import org.hartford.eventguard.repo.EventRepository;
import org.hartford.eventguard.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    public String createEvent(EventRequest request, String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Event event = new Event();

        // Common fields
        event.setEventName(request.getEventName());
        event.setEventType(request.getEventType());
        event.setEventDate(request.getEventDate());
        event.setLocation(request.getLocation());
        event.setBudget(request.getBudget());
        event.setNumberOfAttendees(request.getNumberOfAttendees());
        event.setDurationInDays(request.getDurationInDays());
        event.setVenueType(request.getVenueType());
        event.setLocationRiskLevel(request.getLocationRiskLevel());
        event.setSecurityLevel(request.getSecurityLevel());

        // Music concert specific fields
        event.setAlcoholAllowed(request.getAlcoholAllowed());
        event.setTemporaryStage(request.getTemporaryStage());
        event.setFireworksUsed(request.getFireworksUsed());
        event.setCelebrityInvolved(request.getCelebrityInvolved());

        // Conference specific fields
        event.setTemporaryBooths(request.getTemporaryBooths());
        event.setHighValueEquipment(request.getHighValueEquipment());
        event.setEmergencyPreparednessLevel(request.getEmergencyPreparednessLevel());

        event.setUser(user);

        eventRepository.save(event);

        return "Event created successfully";
    }

    public List<Event> getMyEvents(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return eventRepository.findByUser(user);
    }

    public Event getEventById(Long id) {

        return eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    public String updateEvent(Long id, EventRequest request) {

        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

        // Common fields
        event.setEventName(request.getEventName());
        event.setEventType(request.getEventType());
        event.setEventDate(request.getEventDate());
        event.setLocation(request.getLocation());
        event.setBudget(request.getBudget());
        event.setNumberOfAttendees(request.getNumberOfAttendees());
        event.setDurationInDays(request.getDurationInDays());
        event.setVenueType(request.getVenueType());
        event.setLocationRiskLevel(request.getLocationRiskLevel());
        event.setSecurityLevel(request.getSecurityLevel());

        // Music concert specific fields
        event.setAlcoholAllowed(request.getAlcoholAllowed());
        event.setTemporaryStage(request.getTemporaryStage());
        event.setFireworksUsed(request.getFireworksUsed());
        event.setCelebrityInvolved(request.getCelebrityInvolved());

        // Conference specific fields
        event.setTemporaryBooths(request.getTemporaryBooths());
        event.setHighValueEquipment(request.getHighValueEquipment());
        event.setEmergencyPreparednessLevel(request.getEmergencyPreparednessLevel());

        eventRepository.save(event);

        return "Event updated successfully";
    }

    public String deleteEvent(Long id) {

        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

        eventRepository.delete(event);

        return "Event deleted successfully";
    }
}