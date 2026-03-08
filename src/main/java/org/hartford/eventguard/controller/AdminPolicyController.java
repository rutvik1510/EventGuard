package org.hartford.eventguard.controller;

import org.hartford.eventguard.dto.PolicyRequest;
import org.hartford.eventguard.entity.Policy;
import org.hartford.eventguard.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/policies")
public class AdminPolicyController {

    @Autowired
    private PolicyService policyService;

    @PostMapping
    public String createPolicy(@RequestBody PolicyRequest request) {
        policyService.createPolicy(request);
        return "Policy created successfully";
    }

    @GetMapping
    public java.util.List<Policy> getAllPolicies() {
        return policyService.getAllPolicies();
    }

    @GetMapping("/{id}")
    public Policy getPolicyById(@PathVariable Long id) {
        return policyService.getPolicyById(id);
    }


    @PutMapping("/{id}")
    public String updatePolicy(@PathVariable Long id, @RequestBody PolicyRequest request) {
        policyService.updatePolicy(id, request);
        return "Policy updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deactivatePolicy(@PathVariable Long id) {
        policyService.deactivatePolicy(id);
        return "Policy deactivated successfully";
    }
}