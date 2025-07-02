package com.collegehelper.controllers;

import com.collegehelper.models.BudgetEntry;
import com.collegehelper.services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Accepts a list of budget entries and returns an Excel spreadsheet.
 */
@RestController
@RequestMapping("/api/student")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    /**
     * Generate a budget Excel spreadsheet from entries.
     */
    @PostMapping("/generate-budget-excel")
    public ResponseEntity<ByteArrayResource> generateExcel(@RequestBody List<BudgetEntry> entries) throws Exception {
        byte[] excelBytes = budgetService.generateBudgetExcel(entries);
        ByteArrayResource resource = new ByteArrayResource(excelBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=budget.xlsx");
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(resource.contentLength())
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(resource);
    }
}
