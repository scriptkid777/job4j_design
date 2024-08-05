package ru.job4j.srp.model;

import java.util.List;
import java.util.function.Predicate;

public interface Store {
    void add(Employee employee);

    List<Employee> findby(Predicate<Employee> filter);

}
