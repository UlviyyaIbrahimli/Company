package task.project.ultra.model;

import lombok.Data;

import java.util.Date;

@Data
public class Employee {
    private Long number;
    private Long id_employee;
    private String name;
    private String surname;
    private String fatherName;
    private Date dob;
    private Date beginWorkDate;
    private String gender;
    private String department;
    private String branch;
    private String situation;
    private Integer active;
    private Date dataDate;
}
