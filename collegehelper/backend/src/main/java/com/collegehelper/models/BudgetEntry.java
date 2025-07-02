package com.collegehelper.models;

import lombok.*;

/**
 * Budget entry (used for Excel generation).
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class BudgetEntry {
    private String category;
    private Double amount;
}
