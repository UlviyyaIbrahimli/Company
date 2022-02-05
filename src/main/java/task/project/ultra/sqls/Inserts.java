package task.project.ultra.sqls;

public class Inserts {
    public static final String addEmployeeWithExcel =
            "insert into task.employee( name, surname, father_name, gender,dob,begin_work_date,position_id) " +
                    "values(?,?,?,?,?,?,?);";


}
