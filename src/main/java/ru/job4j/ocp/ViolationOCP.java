package ru.job4j.ocp;

public class ViolationOCP {
    public double calculateArea(String shape, double... dimensions) {
        if (shape.equals("circle")) {
            return Math.PI * dimensions[0] * dimensions[0]; /* радиус */
        } else if (shape.equals("rectangle")) {
            return dimensions[0] * dimensions[1]; /* ширина и высота */
        }
        return 0;
    }
    /*
     Нарушение: При добавлении новой фигуры (например, треугольника)
     необходимо изменять код метода `calculateArea`, что нарушает принцип OCP.
     */

    class PaymentProcessor {
        public void processPayment(String paymentType, double amount) {
            if (paymentType.equals("credit")) {
                System.out.println("логика для обработки кредитных карт");
            } else if (paymentType.equals("paypal")) {
                System.out.println("логика для обработки paypal");
            }
        }
    }
    /*
     Нарушение: Добавление нового типа оплаты (например, биткойн)
    требует изменения метода `processPayment`, что является нарушением принципа OCP.
     */

    class NotificationService {
        public void sendNotification(String notificationType, String message) {
            if (notificationType.equals("email")) {
                System.out.println("логика отправки email");
            } else if (notificationType.equals("sms")) {
                System.out.println("логика отправки SMS");
            }
        }
    }
     /*
     Нарушение:Если нужно добавить новый способ уведомления (например, MMS-уведомления),
      потребуется изменить метод `sendNotification`, что противоречит принципу OCP.
     */
}
