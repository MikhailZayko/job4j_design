package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class ProgrammersReport implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public ProgrammersReport(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name,Hired,Fired,Salary");
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(",")
                    .append(dateTimeParser.parse(employee.getHired())).append(",")
                    .append(dateTimeParser.parse(employee.getFired())).append(",")
                    .append(employee.getSalary());
        }
        return text.toString();
    }
}
