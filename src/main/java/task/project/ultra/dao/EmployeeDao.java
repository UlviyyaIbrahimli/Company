package task.project.ultra.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import task.project.ultra.dao.impl.IEmployeeDao;
import task.project.ultra.model.Employee;
import task.project.ultra.request.ReqEmployee;
import task.project.ultra.sqls.Inserts;
import task.project.ultra.sqls.Selects;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeDao implements IEmployeeDao {
    @Autowired
    DataSource dataSource;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public List<Employee> getEmployeeList() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = Selects.getEmployeeList;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
    }


    @Override
    public void addEmployeeWithExcel(ReqEmployee reqEmployee) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = Inserts.addEmployeeWithExcel;
        Date dob = sdf.parse(reqEmployee.getDob());
        Date beginWorkDate=sdf.parse(reqEmployee.getBeginWorkDate());
        jdbcTemplate.update(sql, new Object[]{reqEmployee.getName(), reqEmployee.getSurname(), reqEmployee.getFatherName(), reqEmployee.getGender(),
                dob, beginWorkDate, reqEmployee.getPosition().getIdSituation()});

    }
}