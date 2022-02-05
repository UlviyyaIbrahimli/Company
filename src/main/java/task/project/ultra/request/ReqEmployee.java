package task.project.ultra.request;

import lombok.Data;
import task.project.ultra.model.Position;

@Data
public class ReqEmployee {
    private String name;
    private String surname;
    private String fatherName;
    private String dob;
    private String gender;
    private String beginWorkDate;
    private Position position;
}
