package com.collegehelper.services;

import org.springframework.stereotype.Service;

/**
 * Service for grade-related calculations.
 * Contains logic to calculate the required grade needed on the final exam.
 */
@Service
public class GradeService {

    /**
     * Calculates the minimum score needed on the final exam to reach a target overall score.
     *
     * @param currentScore   Current total points/score earned so far (not percentage).
     * @param targetScore    Target overall score to pass (as percentage, e.g., 70 for 70%).
     * @param totalPossible  Total points possible for the course (e.g., 100).
     * @param finalWeight    Points the final exam is worth.
     * @return               Minimum score needed on the final exam to reach the target.
     */
    public double calculateNeededGrade(double currentScore, double targetScore, double totalPossible, double finalWeight) {
        // Formula: What do I need on the final to reach my goal?
        // Needed = [target * totalPossible - current * (totalPossible - finalWeight)] / finalWeight
        return (targetScore * totalPossible - currentScore * (totalPossible - finalWeight)) / finalWeight;
    }
}
