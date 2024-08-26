package ru.job4j.srp.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.function.Predicate;

public class JSONReport  implements Report {
    private final Store store;


    public JSONReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Employee.class, new JSONAdapter());
       Gson gson = builder.setPrettyPrinting().create();
        return gson.toJson(store.findby(filter));
    }
}
