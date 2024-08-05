package ru.job4j.srp.model;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class DeveloperReportTest {

    @Test
    public void whenDeveloperGenerated() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report report = new DeveloperReport(store, parser);
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append("; ")
                .append(parser.parse(worker.getHired())).append("; ")
                .append(parser.parse(worker.getFired())).append("; ")
                .append(worker.getSalary())
                .append(System.lineSeparator());
        assertThat(report.generate(employee -> true)).isEqualTo(expected.toString());
    }
}
