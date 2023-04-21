package com.bob.portfoliospring.web.controller;

import com.bob.portfoliospring.domain.model.Project;
import com.bob.portfoliospring.web.dto.ProjectDTO;
import com.bob.portfoliospring.web.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/")
    public List<ProjectDTO> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ProjectDTO getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @PostMapping("/")
    public ProjectDTO saveOrUpdateProject(@RequestParam Long personalInformationId, @RequestBody Project project) {
        return projectService.saveProjectWithPersonalInformation(personalInformationId, project);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }
}
