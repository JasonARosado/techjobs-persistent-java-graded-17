package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

@Entity
public class Employer extends AbstractEntity {
    @NotBlank
    @Size(min = 2, max = 50)
    public String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) { this.location = location; }
}
