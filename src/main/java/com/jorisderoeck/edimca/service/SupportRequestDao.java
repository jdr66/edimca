package com.jorisderoeck.edimca.service;

import com.jorisderoeck.edimca.entity.SupportRequest;

import java.util.List;

public interface SupportRequestDao {
    List<SupportRequest> findAll();
    void insertSupportRequest(SupportRequest sr);
    void updateSupportRequest(SupportRequest sr);
    void executeUpdateSupportRequest(SupportRequest sr);
    void deleteSupportRequest(SupportRequest sr);
}