package com.view;

import com.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResourceRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Resource> getAll(){
        return jdbcTemplate.query("SELECT id,name,comment FROM resource",
                BeanPropertyRowMapper.newInstance(Resource.class));
    }

    public Resource getById(int id) {
        return jdbcTemplate.queryForObject("SELECT id,name,comment FROM resource WHERE " + "id = ?",
                BeanPropertyRowMapper.newInstance(Resource.class), id);
    }

    public int save(List<Resource> resources) {
        resources.forEach(resource ->
        jdbcTemplate.update("INSERT INTO resource(name,comment) VALUES(?,?)", resource.getName(),resource.getComment()));
        return 0;
    }

    public int update(Resource resource){
        return jdbcTemplate.update("UPDATE resource SET name=?,comment=? WHERE id=?",
                resource.getName(),resource.getComment(),resource.getId());
    }

    public int delete(int id){
        return jdbcTemplate.update("DELETE FROM resource WHERE id=?", id);
    }
}
