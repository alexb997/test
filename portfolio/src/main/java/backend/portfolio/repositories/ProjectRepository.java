package backend.portfolio.repositories;

import backend.portfolio.models.Project;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends MongoRepository<Project, Integer> {
}
