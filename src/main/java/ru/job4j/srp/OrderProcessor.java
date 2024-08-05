package ru.job4j.srp;

/*
Код написал внутри комментария чтобы компилятор не ругался на сущность order
Нарушение: Класс `OrderProcessor` отвечает за обработку заказов,
отправку подтверждений и генерацию счетов. Это тоже несколько обязанностей.


public class OrderProcessor {
    public void processOrder(Order order) {
         Логика обработки заказа
        System.out.println("Processing order: " + order.getId());
    }
    public void sendConfirmationEmail(Order order) {
         Логика отправки подтверждения по email
        System.out.println("Sending confirmation email for order: " + order.getId());
    }

    public void generateInvoice(Order order) {
        Логика генерации счета
        System.out.println("Generating invoice for order: " + order.getId());
    }
}

 */
