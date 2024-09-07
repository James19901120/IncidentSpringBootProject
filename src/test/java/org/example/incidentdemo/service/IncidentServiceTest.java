package org.example.incidentdemo.service;


import org.example.incidentdemo.model.Incident;
import org.example.incidentdemo.repository.IncidentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class IncidentServiceTest {

    private IncidentService incidentService;
    private IncidentRepository incidentRepository;

    @BeforeEach
    void setUp() {
        incidentRepository = mock(IncidentRepository.class);
        incidentService = new IncidentService(incidentRepository);
    }

    @Test
    void testAddIncident() {
        Incident incident = new Incident(null, "New Incident", "Open");
        when(incidentRepository.save(incident)).thenReturn(new Incident(1L, "New Incident", "Open"));

        Incident savedIncident = incidentService.addIncident(incident);
        assertEquals(1L, savedIncident.getId());
        verify(incidentRepository, times(1)).save(incident);
    }

    @Test
    void testGetAllIncidents() {
        when(incidentRepository.findAll()).thenReturn(List.of(new Incident(1L, "Incident 1", "Open")));

        List<Incident> incidents = incidentService.getAllIncidents();
        assertEquals(1, incidents.size());
    }

    @Test
    void testUpdateIncident() {
        Incident incident = new Incident(null, "Updated Incident", "Closed");
        when(incidentRepository.update(1L, incident)).thenReturn(new Incident(1L, "Updated Incident", "Closed"));

        Incident updatedIncident = incidentService.updateIncident(1L, incident);
        assertEquals("Closed", updatedIncident.getStatus());
    }

    @Test
    void testDeleteIncident() {
        doNothing().when(incidentRepository).delete(1L);
        incidentService.deleteIncident(1L);
        verify(incidentRepository, times(1)).delete(1L);
    }
}