package backend.portfolio.config;

import backend.portfolio.models.Project;
import backend.portfolio.services.ProjectService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@EnableMongoRepositories(basePackageClasses = ProjectService.class)
@Configuration
public class MongoConfig {
    @Bean
    CommandLineRunner commandLineRunner(ProjectService projectService) {
        return strings -> {
            projectService.create(new Project(1, "test1", "Working","url","active"));
            projectService.create(new Project(2, "test2", "Failing","url","active"));
        };
    }
}