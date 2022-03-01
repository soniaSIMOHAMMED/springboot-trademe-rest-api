package com.springboot.trademe.use_cases.project.exposition;

import com.springboot.trademe.kernel.CommandBus;
import com.springboot.trademe.kernel.QueryBus;
import com.springboot.trademe.use_cases.project.application.create.CreateProject;
import com.springboot.trademe.use_cases.project.application.delete.DeleteProject;
import com.springboot.trademe.use_cases.project.application.read.RetrieveProjectById;
import com.springboot.trademe.use_cases.project.application.read.RetrieveProjects;
import com.springboot.trademe.use_cases.project.application.read.RetrieveProjectsByCity;
import com.springboot.trademe.use_cases.project.application.update.UpdateProject;
import com.springboot.trademe.use_cases.project.domain.Project;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")

public class ProjectControllerHandler {

    private final CommandBus commandBus;
    private final QueryBus queryBus;


    public ProjectControllerHandler(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @GetMapping(path = "/projects", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProjectsDTO> getAll() {
        final List<Project> projects = queryBus.send(new RetrieveProjects());
        ProjectsDTO projectsDTOResult = new ProjectsDTO(projects.stream().map(project -> new ProjectDTO(project.getProjectId(), project.getCity(), project.getDailyRate(), project.getPeriodOfEngagement(),project.getRequiredSkills(),project.getRequiredTrades())).collect(Collectors.toList()));
        return ResponseEntity.ok(projectsDTOResult);
    }

    @GetMapping(path = "/projects/{city}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProjectsDTO> getAllByCity(@PathVariable(name="city") String city) {
        final List<Project> projects = queryBus.send(new RetrieveProjectsByCity(city));
        ProjectsDTO projectsDTOResult = new ProjectsDTO(projects.stream().map(project -> new ProjectDTO(project.getProjectId(), city, project.getDailyRate(), project.getPeriodOfEngagement(),project.getRequiredSkills(),project.getRequiredTrades())).collect(Collectors.toList()));
        return ResponseEntity.ok(projectsDTOResult);
    }

    @GetMapping(path = "/projects/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable(name="id") Long id) {
        final Project project = queryBus.send(new RetrieveProjectById(id));
        ProjectDTO projectDTO = new ProjectDTO(id, project.getCity(), project.getDailyRate(), project.getPeriodOfEngagement(),project.getRequiredSkills(),project.getRequiredTrades());
        return ResponseEntity.ok(projectDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(path = "/projects", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody ProjectDTO projectDTO) {
        CreateProject createProject = new CreateProject(projectDTO.city, projectDTO.dailyRate, projectDTO.periodOfEngagement, projectDTO.requiredSkills, projectDTO.requiredTrades);
        Long projectId = commandBus.send(createProject);
        return ResponseEntity.created(URI.create("/projects/" + projectId)).build();
    }


    // à refaire
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/projects/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable(name="id") Long id){
        Long projectId = commandBus.send(new DeleteProject(id));
        return new ResponseEntity<>("Project with id " +projectId+ " has been successfully deleted.", HttpStatus.OK);
    }

    // à refaire
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(path = "/projects/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> update(@RequestBody ProjectDTO projectDTO, @PathVariable(name="id") long id){
        UpdateProject updateProject = new UpdateProject(id,projectDTO.city, projectDTO.dailyRate, projectDTO.periodOfEngagement, projectDTO.requiredSkills, projectDTO.requiredTrades);
        Long projectId = commandBus.send(updateProject);
        return new ResponseEntity<>("Project with id " +projectId+ " has been successfully updated.", HttpStatus.OK);

    }







}
