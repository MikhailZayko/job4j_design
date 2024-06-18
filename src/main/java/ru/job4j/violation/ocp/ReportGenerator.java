package ru.job4j.violation.ocp;

import java.util.List;

/**
 * Если нужно добавить новый формат отчета, то придется изменить метод generateReport, добавив новый case.
 * Это нарушает принцип OCP, так как требует изменения существующего кода для добавления новой функциональности.
 */

public class ReportGenerator {

    public String generateReport(String reportType, List<String> data) {
        return switch (reportType) {
            case "PDF" -> "PDF Report";
            case "HTML" -> "HTML Report";
            default -> "Unknown Report Type";
        };
    }
}

