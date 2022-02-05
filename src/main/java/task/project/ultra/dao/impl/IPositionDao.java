package task.project.ultra.dao.impl;

import task.project.ultra.model.Position;

import java.util.List;

public interface IPositionDao {
    List<Position> positionList() throws Exception;

    Position getPositionNameById(Long name) throws Exception;
}
