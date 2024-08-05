package ru.job4j.srp.model;

import java.util.Calendar;
import java.util.function.Predicate;

public class AccountingReport implements Report {
    private final Store store;

    private final DateTimeParser<Calendar> parser;

    private final CurrencyConverter converter;

    public AccountingReport(Store store, DateTimeParser<Calendar> parser, CurrencyConverter converter) {
        this.store = store;
        this.parser = parser;
        this.converter = converter;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findby(filter)) {
            text.append(employee.getName()).append(" ")
                    .append(parser.parse(employee.getHired())).append(" ")
                    .append(parser.parse(employee.getFired())).append(" ")
                    .append(converter.convert(Currency.RUB, employee.getSalary(), Currency.USD))
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}