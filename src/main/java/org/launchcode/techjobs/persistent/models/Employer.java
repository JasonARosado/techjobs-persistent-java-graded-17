package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {
    @NotBlank
    @Size(min = 2, max = 50)
    public String location;

    @JoinColumn(name = "employer_id")
    @OneToMany
    private List<Job> jobs = new ArrayList<>();

    public Employer(String location) {
        this.location = location;
    };
    public Employer(){};
    public String getLocation() {
        return location;
    }


    public void setLocation(String location) { this.location = location; }
}
