package backend.portfolio.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@AllArgsConstructor
public class Project {
    @Id
    private int projectId;

    private String name;

    private String description;

    private String imgUrl;

    private String status;
}
