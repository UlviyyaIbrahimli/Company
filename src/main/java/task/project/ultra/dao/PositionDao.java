package task.project.ultra.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import task.project.ultra.dao.impl.IPositionDao;
import task.project.ultra.model.Position;
import task.project.ultra.sqls.Selects;

import javax.sql.DataSource;
import java.util.List;

@Service
public class PositionDao implements IPositionDao {
    @Autowired
    DataSource dataSource;


    @Override
    public List<Position> positionList() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = Selects.getPositionList;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Position.class));
    }

    @Override
    public Position getPositionNameById(Long name) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = Selects.getPositionNameById;
        List<Position> positionList =
                jdbcTemplate.query(sql, new Object[]{name}, new BeanPropertyRowMapper<>(Position.class));
        if (!positionList.isEmpty()) {
            return positionList.get(0);
        }
        return null;
    }
}
