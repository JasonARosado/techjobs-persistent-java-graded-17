package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {
    @ManyToMany
    public List<Job> jobs = new ArrayList<>();
    @NotBlank
    @Size(max=255)
    public String description;
    public Skill(String description){
        this.description = description;
    };
    public Skill(){}
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    public List<Job> getJobs() {
        return jobs;
    }

}

// TODO Task 3