package task.project.ultra.dao.impl;

import task.project.ultra.model.Employee;
import task.project.ultra.request.ReqEmployee;

import java.util.List;

public interface IEmployeeDao {

    List<Employee> getEmployeeList() throws Exception;

    void addEmployeeWithExcel(ReqEmployee reqEmployee) throws Exception;
}
