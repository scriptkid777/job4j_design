package ru.job4j.srp.model;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import static org.assertj.core.api.Assertions.*;
public class JSONReportTest {
    @Test
    public void whenJSONGenerated() {
        Store store = new MemoryStore();
        Calendar calendar = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", calendar, calendar, 100);
        Employee worker2 = new Employee("Sergey", calendar, calendar, 200);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker1);
        store.add(worker2);
        JSONReport jsonReport  = new JSONReport(store);
        String expected = "[\n"
                +  "  {\n"
                +  "    \"name\": \"Ivan\",\n"
                +  "    \"hired\": \"" + parser.parse(calendar) + "\",\n"
                +  "    \"fired\": \"" + parser.parse(calendar) + "\",\n"
                +  "    \"salary\": 100.0\n"
                +  "  },\n"
                +  "  {\n"
                +  "    \"name\": \"Sergey\",\n"
                +  "    \"hired\": \"" + parser.parse(calendar) + "\",\n"
                +  "    \"fired\": \"" + parser.parse(calendar) + "\",\n"
                +  "    \"salary\": 200.0\n"
                +  "  }\n"
                +  "]";
        assertThat(jsonReport.generate(employee -> true)).isEqualTo(expected);
    }
}
