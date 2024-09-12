package ru.job4j.isp;

public class ViolationISP {

    interface Worker {
        void work();
        void eat();
    }

    class Programmer implements Worker {
        public void work() {
            System.out.println("Writing code...");
        }

        public void eat() {
            System.out.println("Eating lunch...");
        }
    }

    class Manager implements Worker {
        public void work() {
            System.out.println("Managing team...");
        }

        public void eat() {
            /* Менеджер не хочет реализовывать метод eat */
            throw new UnsupportedOperationException();
        }

    }

    /* второй пример */

    interface Machine {
        void start();
        void stop();
        void print();
    }

    class Printer implements Machine {
        public void start() {
            System.out.println("Printer starting...");
        }

        public void stop() {
            System.out.println("Printer stopping...");
        }

        public void print() {
            System.out.println("Printing...");
        }
    }

    class Scanner implements Machine {
        public void start() {
            System.out.println("Scanner starting...");
        }

        public void stop() {
            System.out.println("Scanner stopping...");
        }

        public void print() {
            /* Сканер не может печатать, но обязан реализовать метод */
            throw new UnsupportedOperationException();
        }
    }

    /* третий пример */
    interface Animal {
        void makeSound();
        void fly();
    }

    class Dog implements Animal {
        public void makeSound() {
            System.out.println("Bark");
        }

        public void fly() {
            /* Собака не может летать */
            throw new UnsupportedOperationException();
        }
    }

    class Bird implements Animal {
        public void makeSound() {
            System.out.println("Chirp");
        }

        public void fly() {
            System.out.println("Flying...");
        }
    }
    /*
    Во всех этих примерах интерфейсы слишком широки и требуют реализации методов,
    которые не имеют смысла для всех реализаций. Это и нарушает принцип ISP.
     Правильный подход — создать более узкие интерфейсы, соответствующие
     потребностям конкретных классов.
     */
}
