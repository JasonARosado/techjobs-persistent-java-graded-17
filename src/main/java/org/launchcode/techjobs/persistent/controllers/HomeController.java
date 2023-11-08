package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {
    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private SkillRepository skillRepository;

    @RequestMapping("/")
    public String index(Model model) {
        Iterable<Job>jobs= jobRepository.findAll();
        model.addAttribute("title", "MyJobs");
        model.addAttribute("jobs", jobs);

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
    Iterable<Employer> employers = employerRepository.findAll();
    Iterable<Skill> skills = skillRepository.findAll();
    model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        model.addAttribute("employers", employers);
        model.addAttribute("skills", skills);
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                       Errors errors, Model model, @RequestParam int employerId, @RequestParam(required = false) List<Integer> skills) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "add";
        }
        Optional optEmployer = employerRepository.findById(employerId);
        optEmployer.isPresent();

        if (skills != null) {
            List<Skill> skillsResult = (List<Skill>) skillRepository.findAllById(skills);
            newJob.setSkills(skillsResult); }
        else {
            newJob.setSkills(new ArrayList<>());
        }
        jobRepository.save(newJob);
        return "redirect../";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {
    Optional<Job> job = jobRepository.findById(jobId);
        if (job.isPresent()) {
            model.addAttribute("job", job.get());
        }
            return "view";
    }

}
