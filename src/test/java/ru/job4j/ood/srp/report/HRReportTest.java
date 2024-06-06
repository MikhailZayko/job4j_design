package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;


import static org.assertj.core.api.Assertions.*;

class HRReportTest {

    @Test
    public void whenHRReportGenerated() {
        MemoryStore store = new MemoryStore();
        Employee firstWorker = new Employee("Ivan", 100);
        Employee secondWorker = new Employee("Petr", 50);
        store.add(firstWorker);
        store.add(secondWorker);
        Report hrReport = new HRReport(store);
        StringBuilder expected = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(firstWorker.getName()).append(" ")
                .append(firstWorker.getSalary())
                .append(System.lineSeparator())
                .append(secondWorker.getName()).append(" ")
                .append(secondWorker.getSalary());
        assertThat(hrReport.generate(employee -> true)).isEqualTo(expected.toString());
    }
}