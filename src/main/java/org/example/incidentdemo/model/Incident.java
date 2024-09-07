package org.example.incidentdemo.model;

import jdk.jfr.SettingDefinition;
import lombok.Data;

@Data
public class Incident {

    private Long id;

    private String description;

    private String status;

    public Incident(Long id, String description, String status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }
}