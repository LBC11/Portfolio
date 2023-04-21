package com.bob.portfoliospring.web.service;

import com.bob.portfoliospring.domain.model.PersonalInformation;
import com.bob.portfoliospring.domain.model.Project;
import com.bob.portfoliospring.domain.repository.PersonalInformationRepository;
import com.bob.portfoliospring.domain.repository.ProjectRepository;
import com.bob.portfoliospring.web.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    public List<ProjectDTO> getAllProjects() {
        return projectRepository.findAll().stream()
                .map(ProjectDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public ProjectDTO getProjectById(Long id) {
        return projectRepository.findById(id)
                .map(ProjectDTO::fromEntity)
                .orElse(null);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    public ProjectDTO saveProjectWithPersonalInformation(Long personalInformationId, Project project) {
        Optional<PersonalInformation> personalInformationOptional = personalInformationRepository.findById(personalInformationId);
        if (personalInformationOptional.isPresent()) {
            PersonalInformation personalInformation = personalInformationOptional.get();
            project.setPersonalInformation(personalInformation);
            Project savedProject = projectRepository.save(project);
            return ProjectDTO.fromEntity(savedProject);
        }
        return null;
    }
}
