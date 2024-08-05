package ru.job4j.srp.model;

import java.util.Calendar;
import java.util.function.Predicate;

public class DeveloperReport implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> parser;

    public DeveloperReport(Store store, DateTimeParser<Calendar> parser) {
        this.store = store;
        this.parser = parser;
    }
    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findby(filter)) {
            text.append(employee.getName()).append("; ")
                    .append(parser.parse(employee.getHired())).append("; ")
                    .append(parser.parse(employee.getFired())).append("; ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
