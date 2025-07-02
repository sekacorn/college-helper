package com.collegehelper.services;

import com.collegehelper.models.BudgetEntry;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * Service for generating Excel from budget entries.
 */
@Service
public class BudgetService {
    /**
     * Generates an Excel file (as bytes) for a list of budget entries.
     * @param entries List of budget entries
     * @return byte array of Excel file
     */
    public byte[] generateBudgetExcel(List<BudgetEntry> entries) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Budget");
        int rowIdx = 0;
        // Header row
        XSSFRow header = sheet.createRow(rowIdx++);
        header.createCell(0).setCellValue("Category");
        header.createCell(1).setCellValue("Amount");
        // Data rows
        for (BudgetEntry entry : entries) {
            XSSFRow row = sheet.createRow(rowIdx++);
            row.createCell(0).setCellValue(entry.getCategory());
            row.createCell(1).setCellValue(entry.getAmount());
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out); workbook.close();
        return out.toByteArray();
    }
}
