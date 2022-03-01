package com.springboot.trademe.use_cases.project.exposition;

import java.util.List;
// @XmlRootElement
public class ProjectsDTO {

    public final List<ProjectDTO> projects;

    public ProjectsDTO(List<ProjectDTO> projects) {
        this.projects = projects;
    }


}
