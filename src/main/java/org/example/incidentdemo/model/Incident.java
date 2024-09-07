package org.example.incidentdemo.model;

import jakarta.validation.constraints.NotBlank;
import jdk.jfr.SettingDefinition;
import lombok.Data;

@Data
public class Incident {

    private Long id;
    @NotBlank(message = "Description is mandatory")
    private String description;
    @NotBlank(message = "Status is mandatory")
    private String status;

    public Incident(Long id, String description, String status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }
}