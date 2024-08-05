package ru.job4j.srp.model;

import java.util.List;
import java.util.function.Predicate;
import java.util.Comparator;

public class HrReport implements Report {
    private final Store store;

    public HrReport(Store store) {
        this.store = store;
    }

        @Override
        public String generate(Predicate<Employee> filter) {
            StringBuilder text = new StringBuilder();
            text.append("Name; Salary;")
                    .append(System.lineSeparator());
            List<Employee> tempList = store.findby(filter);
            tempList.sort(byDescSalary());
            for (Employee employee : tempList) {
                text.append(employee.getName()).append(" ")
                        .append(employee.getSalary())
                        .append(System.lineSeparator());
            }
            return text.toString();
        }

        private static Comparator<Employee> byDescSalary() {
            return (e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary());
        }
    }

