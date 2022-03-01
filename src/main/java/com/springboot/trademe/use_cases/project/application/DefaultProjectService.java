package com.springboot.trademe.use_cases.project.application;

import com.springboot.trademe.kernel.exception.ResourceNotFoundException;
import com.springboot.trademe.use_cases.project.domain.Project;
import com.springboot.trademe.use_cases.project.domain.ProjectRepository;
import com.springboot.trademe.use_cases.project.exposition.ProjectDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultProjectService implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public DefaultProjectService(ProjectRepository projectRepository, ModelMapper modelMapper){
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        Project project = mapToEntity(projectDTO);
        Project newProject = this.projectRepository.save(project);
        return mapToDTO(newProject);
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        List<Project> projects = this.projectRepository.findAll();
        return projects.stream().map(project -> mapToDTO(project)).collect(Collectors.toList());    }

    @Override
    public ProjectDTO getProjectById(long id) {
        Project project = this.projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project","id", id));
        return mapToDTO(project);
    }

    @Override
    public ProjectDTO updateProject(ProjectDTO projectDTO, long id) {
        Project project = this.projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project","id", id));

        project.setCity(projectDTO.getCity());
        project.setDailyRate(projectDTO.getDailyRate());
        project.setPeriodOfEngagement(projectDTO.getPeriodOfEngagement());
        project.setRequiredSkills(projectDTO.getRequiredSkills());
        project.setRequiredTrades(projectDTO.getRequiredTrades());
        Project updatedProject = projectRepository.save(project);

        return mapToDTO(updatedProject);
    }

    @Override
    public void deleteProject(long id) {
        Project project = this.projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project","id", id));
        this.projectRepository.delete(project);
    }

    private ProjectDTO mapToDTO(Project project){
        return modelMapper.map(project, ProjectDTO.class);
    }


    private Project mapToEntity(ProjectDTO postDTO){
        return modelMapper.map(postDTO, Project.class);
    }

}
