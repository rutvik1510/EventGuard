package org.hartford.eventguard.dto;


import org.hartford.eventguard.entity.EventDomain;
import java.time.LocalDate;

public class EventRequest {

    private String eventName;
    private EventDomain eventType;
    private LocalDate eventDate;
    private String location;

    private Double budget;
    private Integer numberOfAttendees;
    private Integer durationInDays;

    private Boolean isOutdoor;
    private Boolean alcoholAllowed;
    private Boolean temporaryStructure;
    private Boolean fireworksUsed;
    private Boolean celebrityInvolved;

    private String locationRiskLevel;
    private String securityLevel;

    public EventRequest() {}

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public EventDomain getEventType() {
        return eventType;
    }

    public void setEventType(EventDomain eventType) {
        this.eventType = eventType;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Integer getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(Integer numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

    public Integer getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(Integer durationInDays) {
        this.durationInDays = durationInDays;
    }

    public Boolean getIsOutdoor() {
        return isOutdoor;
    }

    public void setIsOutdoor(Boolean outdoor) {
        isOutdoor = outdoor;
    }

    public Boolean getAlcoholAllowed() {
        return alcoholAllowed;
    }

    public void setAlcoholAllowed(Boolean alcoholAllowed) {
        this.alcoholAllowed = alcoholAllowed;
    }

    public Boolean getTemporaryStructure() {
        return temporaryStructure;
    }

    public void setTemporaryStructure(Boolean temporaryStructure) {
        this.temporaryStructure = temporaryStructure;
    }

    public Boolean getFireworksUsed() {
        return fireworksUsed;
    }

    public void setFireworksUsed(Boolean fireworksUsed) {
        this.fireworksUsed = fireworksUsed;
    }

    public Boolean getCelebrityInvolved() {
        return celebrityInvolved;
    }

    public void setCelebrityInvolved(Boolean celebrityInvolved) {
        this.celebrityInvolved = celebrityInvolved;
    }

    public String getLocationRiskLevel() {
        return locationRiskLevel;
    }

    public void setLocationRiskLevel(String locationRiskLevel) {
        this.locationRiskLevel = locationRiskLevel;
    }

    public String getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel;
    }
}