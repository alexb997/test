package backend.portfolio.controllers;

import backend.portfolio.models.Project;
import backend.portfolio.services.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectsService;

    @GetMapping("/all")
    public ResponseEntity<List<Project>> getAllProjects()
    {
        return ResponseEntity.ok(projectsService.getAllProjects());
    }

    @GetMapping("/{projectid}")
    public ResponseEntity<Project>  getProjects(@PathVariable("projectid") int projectid)
    {
        Optional<Project> project = projectsService.getProjectsById(projectid);
        if (!project.isPresent()) {
            log.error("Id " + projectid + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(project.get());
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable("id") int id)
    {
        projectsService.delete(id);
    }

    @PostMapping("/post")
    public ResponseEntity  saveProject( @RequestBody Project project)
    {
        return ResponseEntity.ok(projectsService.create(project));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable int id, @RequestBody Project project) {
        if (!projectsService.getProjectsById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(projectsService.create(project));
    }
}
