package ru.job4j.srp.model;

public interface CurrencyConverter {
    double convert(Currency source, double sourceValue, Currency target);

}
