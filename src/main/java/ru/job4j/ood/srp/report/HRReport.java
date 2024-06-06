package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class HRReport implements Report {

    private final Store store;

    public HRReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        for (Employee employee : sortedEmployees(store.findBy(filter))) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(" ")
                    .append(employee.getSalary());
        }
        return text.toString();
    }

    private List<Employee> sortedEmployees(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .toList();
    }
}
