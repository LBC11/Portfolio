package com.bob.portfoliospring.web.controller;

import com.bob.portfoliospring.domain.model.Project;
import com.bob.portfoliospring.web.dto.ProjectDTO;
import com.bob.portfoliospring.web.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Project")
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @ApiOperation(value = "Get all projects")
    @GetMapping("/")
    public List<ProjectDTO> getAllProjects() {
        return projectService.getAllProjects();
    }

    @ApiOperation(value = "Get project by ID")
    @GetMapping("/{id}")
    public ProjectDTO getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @ApiOperation(value = "Save or update project")
    @PostMapping("/")
    public ProjectDTO saveOrUpdateProject(@RequestParam Long personalInformationId, @RequestBody Project project) {
        return projectService.saveProjectWithPersonalInformation(personalInformationId, project);
    }

    @ApiOperation(value = "Delete project by ID")
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }
}
