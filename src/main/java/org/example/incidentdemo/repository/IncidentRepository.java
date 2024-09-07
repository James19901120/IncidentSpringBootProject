package org.example.incidentdemo.repository;


import org.example.incidentdemo.model.Incident;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class IncidentRepository {

    private final List<Incident> incidentList = new ArrayList<>();
    private Long currentId = 1L;

    public Incident save(Incident incident) {
        incident.setId(currentId++);
        incidentList.add(incident);
        return incident;
    }

    public List<Incident> findAll() {
        return incidentList;
    }

    public Incident update(Long id, Incident updatedIncident) {
        Optional<Incident> existingIncidentOpt = incidentList.stream().filter(incident -> incident.getId().equals(id)).findFirst();
        if (existingIncidentOpt.isPresent()) {
            Incident existingIncident = existingIncidentOpt.get();
            existingIncident.setDescription(updatedIncident.getDescription());
            existingIncident.setStatus(updatedIncident.getStatus());
            return existingIncident;
        }
        throw new RuntimeException("Incident not found");
    }

    public void delete(Long id) {
        incidentList.removeIf(incident -> incident.getId().equals(id));
    }
}