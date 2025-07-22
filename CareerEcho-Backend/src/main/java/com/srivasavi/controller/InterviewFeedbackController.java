package com.srivasavi.controller;

import com.srivasavi.model.InterviewFeedback;
import com.srivasavi.repository.InterviewFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "*")
public class InterviewFeedbackController {

    @Autowired
    private InterviewFeedbackRepository repository;

    @PostMapping
    public String submitFeedback(@RequestBody InterviewFeedback feedback) {
        repository.save(feedback);
        return "Feedback submitted successfully!";
    }

    @GetMapping
    public List<InterviewFeedback> getAllFeedback() {
        return repository.findAll();
    }

    @GetMapping("/company/{company}")
    public List<InterviewFeedback> getFeedbackByCompany(@PathVariable String company) {
        return repository.findByCompanyIgnoreCase(company);
    }

    @GetMapping("/filter")
    public List<InterviewFeedback> getByFilters(
            @RequestParam String company,
            @RequestParam(required = false) String role,
            @RequestParam(required = false) Integer rounds) {

        if (role != null && !role.isEmpty() && rounds != null) {
            return repository.findByCompanyIgnoreCaseAndRoleIgnoreCaseAndNumberOfRounds(company, role, rounds);
        } else if (role != null && !role.isEmpty()) {
            return repository.findByCompanyIgnoreCaseAndRoleIgnoreCase(company, role);
        } else if (rounds != null) {
            return repository.findByCompanyIgnoreCaseAndNumberOfRounds(company, rounds);
        } else {
            return repository.findByCompanyIgnoreCase(company);
        }
    }

    @GetMapping("/companies")
    public List<String> getCompanyList() {
        return repository.findAll()
                .stream()
                .map(fb -> fb.getCompany().trim())
                .distinct()
                .collect(Collectors.toList());
    }

    @GetMapping("/roles")
    public List<String> getRolesByCompany(@RequestParam(required = false) String company) {
        List<InterviewFeedback> feedbacks = (company != null && !company.isEmpty())
                ? repository.findByCompanyIgnoreCase(company)
                : repository.findAll();

        return feedbacks.stream()
                .map(InterviewFeedback::getRole)
                .filter(role -> role != null && !role.isEmpty())
                .map(String::trim)
                .distinct()
                .collect(Collectors.toList());
    }
}
