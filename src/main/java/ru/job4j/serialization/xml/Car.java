package ru.job4j.serialization.xml;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)

public class Car {
    @XmlAttribute
    private boolean truck;
    @XmlAttribute
    private int power;
    private Number number;
    private String name;
    private String[] statuses;

    public Car(boolean truck, int power, Number number, String name, String[] statuses) {
        this.truck = truck;
        this.power = power;
        this.number = number;
        this.name = name;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Car{" + "truck=" + truck + ", power=" + power + ", number=" + number + ", name='" + name + '\'' + ", statuses=" + Arrays.toString(statuses) + '}';
    }

    public static void main(String[] args) throws JAXBException {
        final Car car = new Car(true, 250, new Number("22-122"), "Man",
                new String[]{"Empty", "Full"});

        JAXBContext context = JAXBContext.newInstance(Car.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(car, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);

        } catch (Exception ignored) {

        }
    }
}
