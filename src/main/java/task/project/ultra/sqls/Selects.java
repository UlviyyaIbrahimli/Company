package task.project.ultra.sqls;

public class Selects {

    public static final String getEmployeeList = "SELECT \n" +
            "    e.id_employee,\n" +
            "    e.name,\n" +
            "    e.surname,\n" +
            "    e.father_name,\n" +
            "    e.dob,\n" +
            "    e.gender,\n" +
            "    e.begin_work_date,\n" +
            "    s.situation_name as situation,\n" +
            "    d.department_name as department,\n" +
            "    b.branch_name as branch\n" +
            "FROM\n" +
            "    task.employee e\n" +
            "        INNER JOIN\n" +
            "    task.situation s ON s.id_situation = e.position_id\n" +
            "        INNER JOIN\n" +
            "    task.branch b ON b.id_branch = s.branch_id\n" +
            "        INNER JOIN\n" +
            "    task.department d ON d.id_department = b.department_id\n" +
            "WHERE\n" +
            "    e.active = 1;";

    public static final String getPositionList = "Select * from task.situation";

    public static final String getPositionNameById = "select * from task.situation where id_situation=?";
}
