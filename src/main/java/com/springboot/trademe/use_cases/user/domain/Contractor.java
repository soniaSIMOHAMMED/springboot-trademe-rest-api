package com.springboot.trademe.use_cases.user.domain;


import com.springboot.trademe.use_cases.project.domain.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/*@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "contractors")*/
public class Contractor extends User{


/*    @OneToMany(mappedBy = "contractor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Project> projects;*/

}
