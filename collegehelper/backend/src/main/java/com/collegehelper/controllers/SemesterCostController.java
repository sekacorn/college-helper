package com.collegehelper.controllers;

import com.collegehelper.services.SemesterCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Calculates the total cost for a semester.
 */
@RestController
@RequestMapping("/api/student")
public class SemesterCostController {

    @Autowired
    private SemesterCostService semesterCostService;

    /**
     * Calculate total out-of-pocket semester cost.
     */
    @PostMapping("/calculate-cost")
    public CostResult calcCost(@RequestBody CostRequest req) {
        double total = semesterCostService.calculateSemesterCost(
                req.getTuition(),
                req.getLiving(),
                req.getBooks(),
                req.getScholarships()
        );
        return new CostResult(total);
    }

    // DTOs (could be in a DTO package)
    public static class CostRequest {
        private double tuition;
        private double living;
        private double books;
        private double scholarships;
        // Getters/setters
        public double getTuition() { return tuition; }
        public void setTuition(double tuition) { this.tuition = tuition; }
        public double getLiving() { return living; }
        public void setLiving(double living) { this.living = living; }
        public double getBooks() { return books; }
        public void setBooks(double books) { this.books = books; }
        public double getScholarships() { return scholarships; }
        public void setScholarships(double scholarships) { this.scholarships = scholarships; }
    }
    public static class CostResult {
        private double total;
        public CostResult(double total) { this.total = total; }
        public double getTotal() { return total; }
        public void setTotal(double total) { this.total = total; }
    }
}
