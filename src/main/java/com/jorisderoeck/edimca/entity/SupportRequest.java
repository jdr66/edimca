package com.jorisderoeck.edimca.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "support_requests")
public class SupportRequest implements Serializable {
    private int request_id;
    private int requester_id;
    private Date creation_time;
    private String name;
    private String description;
    private int approver_id;
    private int priority;
    private Date approve_time;
    private int tech_id;
    private Date assign_time;

    public SupportRequest(){
        this.creation_time = new Date();
    }

    public SupportRequest(int requester_id, String name, String description, int priority) {
        this.requester_id = requester_id;
        this.creation_time = new Date();
        this.name = name;
        this.description = description;
        this.priority = priority;
    }

    @Id
    @Column(name="request_id")
    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    @Column(name="requester_id")
    public int getRequester_id() {
        return requester_id;
    }

    public void setRequester_id(int requester_id) {
        this.requester_id = requester_id;
    }

    @Column(name="creation_time")
    public Date getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(Date creation_time) {
        this.creation_time = creation_time;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="approver_id")
    public int getApprover_id() {
        return approver_id;
    }

    public void setApprover_id(int approver_id) {
        this.approver_id = approver_id;
    }

    @Column(name="priority")
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Column(name="approve_time")
    public Date getApprove_time() {
        return approve_time;
    }

    public void setApprove_time(Date approve_time) {
        this.approve_time = approve_time;
    }

    @Column(name="tech_id")
    public int getTech_id() {
        return tech_id;
    }

    public void setTech_id(int tech_id) {
        this.tech_id = tech_id;
    }

    @Column(name="assign_time")
    public Date getAssign_time() {
        return assign_time;
    }

    public void setAssign_time(Date assign_time) {
        this.assign_time = assign_time;
    }
}
