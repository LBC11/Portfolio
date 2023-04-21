package com.bob.portfoliospring.services;

import com.bob.portfoliospring.entities.PersonalInformation;
import com.bob.portfoliospring.entities.Project;
import com.bob.portfoliospring.repository.PersonalInformationRepository;
import com.bob.portfoliospring.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    public Project saveOrUpdateProject(Project project) {
        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    public Project saveProjectWithPersonalInformation(Long personalInformationId, Project project) {
        Optional<PersonalInformation> personalInformationOptional = personalInformationRepository.findById(personalInformationId);
        if (personalInformationOptional.isPresent()) {
            PersonalInformation personalInformation = personalInformationOptional.get();
            project.setPersonalInformation(personalInformation);
            return projectRepository.save(project);
        }
        return null;
    }
}
