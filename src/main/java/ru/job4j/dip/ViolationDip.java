package ru.job4j.dip;

public class ViolationDip {
    class EmailService {
        public void sendEmail(String message) {
            /* Логика отправки email */
            System.out.println("Email sent: " + message);
        }
    }

    class UserRegistration {
        private EmailService emailService;

        public UserRegistration() {
            this.emailService = new EmailService(); /* Прямое создание зависимости */
        }

        public void registerUser(String username) {
            /* Логика регистрации пользователя  */
            emailService.sendEmail("Welcome " + username);
        }
    }

    class NotificationService {
        public void notifyUser(String message) {
            /* Логика уведомления */
            System.out.println("User notified: " + message);
        }
    }

    class UserProfile {
        public void updateProfile() {
            /* Логика обновления профиля */
            NotificationService notificationService = new NotificationService(); /* Прямое создание зависимости */
            notificationService.notifyUser("Profile updated.");
        }
    }

    class PaymentProcessor {
        public void processPayment() {
            /* Логика обработки платежа  */
            System.out.println("Payment processed.");
        }
    }

    class Checkout {
        private PaymentProcessor paymentProcessor;

        public Checkout() {
            this.paymentProcessor = new PaymentProcessor(); /* Прямое создание зависимости */
        }

        public void completeCheckout() {
            paymentProcessor.processPayment();
        }
    }
    /*
    Для исправления этих примеров следует использовать
    интерфейсы или абстрактные классы,
    чтобы разорвать жесткие связи между классами.
     */
}
