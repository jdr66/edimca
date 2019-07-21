package com.jorisderoeck.edimca.service;

import java.util.List;

import javax.annotation.Resource;

import com.jorisderoeck.edimca.entity.SupportRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


@RestController
@Component
@RequestMapping("/postgressApp")
public class Controller {

    @Resource
    SupportRequestDaoImpl srService;

    @GetMapping(value = "/requestList")
    public List<SupportRequest> getRequests() {
        return srService.findAll();
    }

    @PostMapping(value = "/createRequest")
    public void createRequest(@RequestBody SupportRequest sr) {
        srService.insertSupportRequest(sr);
    }

    @PutMapping(value = "/updateRequest")
    public void updateRequest(@RequestBody SupportRequest sr) {
        srService.updateSupportRequest(sr);
    }

    @PutMapping(value = "/executeUpdateRequest")
    public void executeUpdateRequest(@RequestBody SupportRequest sr) {
        srService.executeUpdateSupportRequest(sr);

    }

    @DeleteMapping(value = "/deleteRequestById")
    public void deleteRequest(@RequestBody SupportRequest sr) {
        srService.deleteSupportRequest(sr);
    }

}