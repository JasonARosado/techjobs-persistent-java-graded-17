package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Skill extends AbstractEntity {
    @NotBlank
    @Size(max=255)
    public String description;
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}

// TODO Task 3