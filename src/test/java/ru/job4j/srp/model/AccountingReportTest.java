package ru.job4j.srp.model;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class AccountingReportTest {
      @Test

    public void whenAccountingGenerated() {
          MemoryStore store = new MemoryStore();
          Calendar now = Calendar.getInstance();
          Employee worker = new Employee("Ivan", now, now, 100);
          DateTimeParser<Calendar> parser = new ReportDateTimeParser();
          store.add(worker);
          CurrencyConverter converter = new InMemoryCurrencyConverter();
         Report report = new AccountingReport(store, parser, converter);
          StringBuilder expected = new StringBuilder()
                  .append("Name; Hired; Fired; Salary;")
                  .append(System.lineSeparator())
                  .append(worker.getName()).append(" ")
                  .append(parser.parse(worker.getHired())).append(" ")
                  .append(parser.parse(worker.getFired())).append(" ")
                  .append(converter.convert(Currency.RUB, worker.getSalary(), Currency.USD))
                  .append(System.lineSeparator());
          assertThat(report.generate(employee -> true)).isEqualTo(expected.toString());
          }
    }
