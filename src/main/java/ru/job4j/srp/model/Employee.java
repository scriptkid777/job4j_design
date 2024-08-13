package ru.job4j.srp.model;

import java.util.Calendar;
import java.util.Objects;


public class Employee {
    private String name;
    private Calendar hired;
    private Calendar fired;
    private double salary;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Employee(String name, Calendar hired, Calendar fired, double salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHired(Calendar hired) {
        this.hired = hired;
    }

    public void setFired(Calendar fired) {
        this.fired = fired;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Calendar getHired() {
        return hired;
    }

    public Calendar getFired() {
        return fired;
    }

    public double getSalary() {
        return salary;
    }
}
