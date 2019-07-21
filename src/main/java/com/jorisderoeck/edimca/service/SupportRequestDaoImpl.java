package com.jorisderoeck.edimca.service;

import com.jorisderoeck.edimca.entity.SupportRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SupportRequestDaoImpl implements SupportRequestDao {
    NamedParameterJdbcTemplate template;

    @Override
    public List<SupportRequest> findAll() {
        return template.query("select * from support_requests", new SupportRequestRowMapper());
    }

    @Override
    public void insertSupportRequest(SupportRequest sr) {

        final String sql = "insert into support_requests(" +
                "requester_id, " +
                "creation_time, " +
                "name, " +
                "description, " +
                "priority, " +
                " values(" +
                ":requester_id," +
                ":creation_time," +
                ":name," +
                ":description" +
                ":priority)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("requester_id", sr.getRequester_id())
                .addValue("creation_time", sr.getCreation_time())
                .addValue("name", sr.getName())
                .addValue("description", sr.getDescription())
                .addValue("priority", sr.getPriority());
        template.update(sql, param, holder);
    }

    @Override
    public void updateSupportRequest(SupportRequest sr) {

        final String sql = "update support_requests set " +
                "approver_id=:approver_id, " +
                "approve_time=:approve_time, " +
                "tech_id=:tech_id, " +
                "assign_time=:assign_time, " +
                "where request_id=:request_id";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("approver_id", sr.getApprover_id())
                .addValue("approve_time", sr.getApprove_time())
                .addValue("tech_id", sr.getTech_id())
                .addValue("assign_time", sr.getAssign_time())
                .addValue("request_id", sr.getRequest_id());

        template.update(sql, param, holder);
    }

    @Override
    public void executeUpdateSupportRequest(SupportRequest sr) {
        final String sql = "update support_requests set " +
                "approver_id=:approver_id, " +
                "approve_time=:approve_time, " +
                "tech_id=:tech_id, " +
                "assign_time=:assign_time, " +
                "where request_id=:request_id";
        Map<String, Object> map = new HashMap<>();

        map.put("approver_id", sr.getApprover_id());
        map.put("approve_time", sr.getApprove_time());
        map.put("tech_id", sr.getTech_id());
        map.put("assign_time", sr.getAssign_time());
        map.put("request_id", sr.getRequest_id());

        template.execute(sql, map, new PreparedStatementCallback<Object>() {

            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }

        });
    }

    @Override
    public void deleteSupportRequest(SupportRequest sr) {

        final String sql = "delete from support_requests where request_id=:request_id";

        Map<String,Object> map=new HashMap<String,Object>();

        map.put("request_id", sr.getRequest_id());

        template.execute(sql,map,new PreparedStatementCallback<Object>() {

            @Override

            public Object doInPreparedStatement(PreparedStatement ps)

                    throws SQLException, DataAccessException {

                return ps.executeUpdate();

            }

        });

    }
}