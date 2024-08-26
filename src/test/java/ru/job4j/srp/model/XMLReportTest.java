package ru.job4j.srp.model;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import static org.assertj.core.api.Assertions.*;

public class XMLReportTest {
    @Test
    public void whenXMLGenerated() {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Sergey", now, now, 200);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker1);
        store.add(worker2);
        XMLReport xmlReport  = new XMLReport(store);
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<employees>\n"
                +  "    <employee>\n"
                +  "        <name>Ivan</name>\n"
                +  "        <hired>" + parser.parse(now) + "</hired>\n"
                +  "        <fired>" + parser.parse(now) + "</fired>\n"
                +  "        <salary>100.0</salary>\n"
                +  "    </employee>\n"
                +  "    <employee>\n"
                +  "        <name>Sergey</name>\n"
                +  "        <hired>" + parser.parse(now) + "</hired>\n"
                +  "        <fired>" + parser.parse(now) + "</fired>\n"
                +  "        <salary>200.0</salary>\n"
                +  "    </employee>\n"
                +  "</employees>\n";
            assertThat(xmlReport.generate(employee -> true)).isEqualTo(expected);
    }
}
