package ru.job4j.serialization.xml;

import javax.xml.bind.*;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        Car car = new Car(true, 200, new Number("11-111"), "Man",
                new String[]{"Empty", "Full"});
        /* Получаем контекст для доступа к АПИ */
        JAXBContext context = JAXBContext.newInstance(Car.class);
        Marshaller marshaller = context.createMarshaller();
        /* Указываем, что нам нужно форматирование */
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter())   {
            /* Сериализуем */
            marshaller.marshal(car, writer);
            String xml = writer.getBuffer().toString();
            System.out.println(xml);

            /* Для десериализации нам нужно создать десериализатор */
            Unmarshaller unmarshaller = context.createUnmarshaller();
            try (StringReader reader = new StringReader(xml)) {
                /* десериализуем */
              Car result = (Car) unmarshaller.unmarshal(reader);
                System.out.println(result);
            }
        }
    }
}