package org.example.incidentdemo.service;


import org.example.incidentdemo.model.Incident;
import org.example.incidentdemo.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentService {
    private IncidentRepository incidentRepository;

    public IncidentService(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    public Incident addIncident(Incident incident) {
        return incidentRepository.save(incident);
    }

    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    public Incident updateIncident(Long id, Incident incident) {
        return incidentRepository.update(id, incident);
    }

    public void deleteIncident(Long id) {
        incidentRepository.delete(id);
    }
}