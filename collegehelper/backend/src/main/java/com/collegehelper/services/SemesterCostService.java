package com.collegehelper.services;

import org.springframework.stereotype.Service;

/**
 * Service for grade calculations.
 */
@Service
public class GradeService {
    /**
     * Calculates required score on the final exam to achieve target grade.
     * @param currentScore - current cumulative grade
     * @param targetScore - desired grade
     * @param totalPossible - total points for course
     * @param finalWeight - points the final exam is worth
     * @return required score on final
     */
    public double calculateNeededGrade(double currentScore, double targetScore, double totalPossible, double finalWeight) {
        // Formula: What do I need on the final?
        return (targetScore * totalPossible - currentScore * (totalPossible - finalWeight)) / finalWeight;
    }
}
