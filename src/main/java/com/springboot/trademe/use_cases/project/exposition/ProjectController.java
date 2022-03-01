package com.springboot.trademe.use_cases.project.exposition;

import com.springboot.trademe.use_cases.project.application.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService=projectService;
    }

    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDTO){
        return new ResponseEntity<>(this.projectService.createProject(projectDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ProjectDTO> getAllProjects(){
        return this.projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(this.projectService.getProjectById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDTO> updateProject(@RequestBody ProjectDTO projectDTO, @PathVariable(name = "id") long id){
        return new ResponseEntity<>(this.projectService.updateProject(projectDTO,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable(name = "id") long id){
        this.projectService.deleteProject(id);
        return new ResponseEntity<>("Project has been successfully deleted.", HttpStatus.OK);
    }





}
