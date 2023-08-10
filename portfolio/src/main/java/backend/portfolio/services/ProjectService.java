package backend.portfolio.services;

import backend.portfolio.models.Project;
import backend.portfolio.repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects()
    {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectsById(int id)
    {
        return projectRepository.findById(id);
    }

    public Project create(Project project)
    {
        return projectRepository.save(project);
    }

    public void delete(int projectid)
    {
        projectRepository.deleteById(projectid);
    }

}
