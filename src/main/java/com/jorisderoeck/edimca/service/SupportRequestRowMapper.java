package com.jorisderoeck.edimca.service;
import com.jorisderoeck.edimca.entity.SupportRequest;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupportRequestRowMapper implements RowMapper<SupportRequest>{
    @Override
    public SupportRequest mapRow(ResultSet rs, int arg1) throws SQLException{
        SupportRequest supportRequest = new SupportRequest();
        supportRequest.setRequest_id(rs.getInt("request_id"));
        supportRequest.setRequester_id(rs.getInt("requester_id"));
        supportRequest.setCreation_time(rs.getDate("creation_time"));
        supportRequest.setName(rs.getString("name"));
        supportRequest.setDescription(rs.getString("description"));
        supportRequest.setApprover_id(rs.getInt("approver_id"));
        supportRequest.setPriority(rs.getInt("priority"));
        supportRequest.setApprove_time(rs.getDate("approve_time"));
        supportRequest.setTech_id(rs.getInt("tech_id"));
        supportRequest.setAssign_time(rs.getDate("assign_time"));
        return supportRequest;
    }
}