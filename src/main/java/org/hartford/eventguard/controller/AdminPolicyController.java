package org.hartford.eventguard.controller;

import org.hartford.eventguard.dto.PolicyRequest;
import org.hartford.eventguard.entity.Policy;
import org.hartford.eventguard.repo.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/policies")
public class AdminPolicyController {

    @Autowired
    private PolicyRepository policyRepository;

    // 🔹 CREATE POLICY (ADMIN ONLY)
    @PostMapping
    public String createPolicy(@RequestBody PolicyRequest request) {

        Policy policy = new Policy();

        policy.setPolicyName(request.getPolicyName());
        policy.setDescription(request.getDescription());
        policy.setDomain(request.getDomain());
        policy.setBaseRate(request.getBaseRate());
        policy.setMaxCoverageAmount(request.getMaxCoverageAmount());
        policy.setIsActive(true);

        policyRepository.save(policy);

        return "Policy created successfully";
    }

    // 🔹 VIEW ALL POLICIES (ADMIN)
    @GetMapping
    public java.util.List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Policy getPolicyById(@PathVariable Long id) {

        return policyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Policy not found"));
    }


    @PutMapping("/{id}")
    public String updatePolicy(@PathVariable Long id,
                               @RequestBody PolicyRequest request) {

        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Policy not found"));

        policy.setPolicyName(request.getPolicyName());
        policy.setDescription(request.getDescription());
        policy.setDomain(request.getDomain());
        policy.setBaseRate(request.getBaseRate());
        policy.setMaxCoverageAmount(request.getMaxCoverageAmount());

        policyRepository.save(policy);

        return "Policy updated successfully";
    }

    //  SOFT DELETE POLICY (better than hard delete)
    @DeleteMapping("/{id}")
    public String deactivatePolicy(@PathVariable Long id) {

        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Policy not found"));

        policy.setIsActive(false);

        policyRepository.save(policy);

        return "Policy deactivated successfully";
    }
}