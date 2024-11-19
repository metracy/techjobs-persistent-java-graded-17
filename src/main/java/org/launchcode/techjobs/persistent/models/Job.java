package org.launchcode.techjobs.persistent.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import org.launchcode.techjobs.persistent.models.Skill;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import java.util.List;

@Entity
public class Job extends AbstractEntity {


    @ManyToOne
    private Employer employer;



    // since I wound up creating the job_skills in mySQL database directly at one point, I'm stuck with this convoluted solution
    // so that it maps properly.
    @ManyToMany
    @JoinTable(name = "job_skills",
              joinColumns = @JoinColumn(name = "job_id"),
              inverseJoinColumns = @JoinColumn(name = "skills_id"))
    private List<Skill> skills = new ArrayList<>();

    // Fix the error in test that flags if job is constructed without parameters
    public Job() {}

    // Constructor to initialize employer
    public Job(Employer anEmployer, List<Skill> someSkills) {
        super();
        this.employer = anEmployer;
        this.skills = someSkills;
    }

    // Getter and setter for Employer
    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }


}