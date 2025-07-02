package com.collegehelper.controllers;

import com.collegehelper.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * API endpoints for grade calculation features.
 */
@RestController
@RequestMapping("/api/student")
public class GradeCalculatorController {

    @Autowired
    private GradeService gradeService;

    /**
     * Endpoint to calculate the required score on the final exam.
     * Receives JSON in the format:
     * {
     *   "currentScore": number,
     *   "targetScore": number,
     *   "totalPossible": number,
     *   "finalWeight": number
     * }
     */
    @PostMapping("/calculate-grade")
    public GradeResult calculateGrade(@RequestBody GradeRequest req) {
        double needed = gradeService.calculateNeededGrade(
                req.getCurrentScore(),
                req.getTargetScore(),
                req.getTotalPossible(),
                req.getFinalWeight()
        );
        return new GradeResult(needed);
    }

    // --- DTOs ---

    /**
     * Request DTO for grade calculation.
     */
    public static class GradeRequest {
        private double currentScore;
        private double targetScore;
        private double totalPossible;
        private double finalWeight;
        // Getters and setters
        public double getCurrentScore() { return currentScore; }
        public void setCurrentScore(double currentScore) { this.currentScore = currentScore; }
        public double getTargetScore() { return targetScore; }
        public void setTargetScore(double targetScore) { this.targetScore = targetScore; }
        public double getTotalPossible() { return totalPossible; }
        public void setTotalPossible(double totalPossible) { this.totalPossible = totalPossible; }
        public double getFinalWeight() { return finalWeight; }
        public void setFinalWeight(double finalWeight) { this.finalWeight = finalWeight; }
    }

    /**
     * Response DTO for grade calculation result.
     */
    public static class GradeResult {
        private double needed;
        public GradeResult(double needed) { this.needed = needed; }
        public double getNeeded() { return needed; }
        public void setNeeded(double needed) { this.needed = needed; }
    }
}
