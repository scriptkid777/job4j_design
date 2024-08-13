package ru.job4j.srp.model;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class HrReportTest {
@Test
    public void whenHRGenerated() {
    MemoryStore store = new MemoryStore();
    Calendar now = Calendar.getInstance();
    Employee worker1 = new Employee("Ivan", now, now, 100);
    Employee worker2 = new Employee("Alex", now, now, 150);
    DateTimeParser<Calendar> parser = new ReportDateTimeParser();
    store.add(worker1);
    store.add((worker2));
    Report engine = new HrReport(store);
    StringBuilder expected = new StringBuilder()
            .append("Name; Salary;")
            .append(System.lineSeparator())
            .append(worker2.getName()).append(" ")
            .append(worker2.getSalary())
            .append(System.lineSeparator())
            .append(worker1.getName()).append(" ")
            .append(worker1.getSalary())
            .append(System.lineSeparator());
    assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }
}
