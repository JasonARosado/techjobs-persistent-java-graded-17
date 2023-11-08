package org.launchcode.techjobs.persistent.controllers;
import jakarta.persistence.Index;
import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("skills")
public class SkillController {
    @Autowired
    private SkillRepository skillRepository;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Skill> allSkills = skillRepository.findAll();
        model.addAttribute("skills", allSkills);
        return "skills/index";
    }

    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute(new Skill());
        return "skills/add";
    }
    @GetMapping("add")
    public String displayViewSkill(Model model) {
        model.addAttribute(new Employer());
        return "employer/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                      Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "skills/add";
        }
        skillRepository.save(newSkill);
        return "redirect:";
    }
}
