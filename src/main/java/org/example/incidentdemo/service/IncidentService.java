package org.example.incidentdemo.service;



import org.example.incidentdemo.model.Incident;
import org.example.incidentdemo.repository.IncidentRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentService {

    private final IncidentRepository incidentRepository;

    public IncidentService(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    @CacheEvict(value = "incidents", allEntries = true)
    public Incident addIncident(Incident incident) {
        return incidentRepository.save(incident);
    }

    @Cacheable(value = "incidents")
    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    @CacheEvict(value = "incidents", allEntries = true)
    public Incident updateIncident(Long id, Incident incident) {
        return incidentRepository.update(id, incident);
    }

    @CacheEvict(value = "incidents", allEntries = true)
    public void deleteIncident(Long id) {
        incidentRepository.delete(id);
    }
}