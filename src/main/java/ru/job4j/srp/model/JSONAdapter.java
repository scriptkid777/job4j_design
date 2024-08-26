package ru.job4j.srp.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.util.Calendar;
import java.lang.reflect.Type;

public class JSONAdapter implements JsonSerializer<Employee> {
    @Override
    public JsonElement serialize(Employee employee, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject object = new JsonObject();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        object.addProperty("name", employee.getName());
        object.addProperty("hired", parser.parse(employee.getHired()));
        object.addProperty("fired", parser.parse(employee.getFired()));
        object.addProperty("salary", employee.getSalary());
        return object;
    }
}
