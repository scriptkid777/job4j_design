package ru.job4j.lsp;

public class ViolationLSP {
   static class Car {
        public void drive() {
            System.out.println("Driving a car");
        }
    }

  static class ElectricCar extends Car {

        @Override
        public void drive() {
            System.out.println("Driving a Electrical Car");
        }

        public void charge() {
             System.out.println("Charging the electric car");
         }
    }

    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.drive();
        Car myElectricCar = new ElectricCar();
        myElectricCar.drive();
        /* Не можем вызвать метод charge, что ограничивает использование подкласса
         myElectricCar.charge();  Ошибка компиляции
         */
    }

  static   class Calculator {
        public int divide(int a, int b) {
            return a / b;
        }
    }

  static  class SafeCalculator extends Calculator {
        @Override
        public int divide(int a, int b) {
            if (b == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            return super.divide(a, b);
        }
    }

    public class Main {
        public static void main(String[] args) {
            Calculator calc = new Calculator();
            System.out.println(calc.divide(10, 2)); /* 5
            */

            Calculator safeCalc = new SafeCalculator();
            System.out.println(safeCalc.divide(10, 0)); /* Неожиданное поведение
            */
        }
    }

  static   class Rectangle {
        protected int width;
        protected int height;

        public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getArea() {
            return width * height;
        }
    }

   static class Square extends Rectangle {
        @Override
        public void setWidth(int width) {
            this.width = width;
            this.height = width; /* Изменяем высоту, нарушая поведение родительского класса
            */
        }

        @Override
        public void setHeight(int height) {
            this.height = height;
            this.width = height; /* Изменяем ширину, нарушая поведение родительского класса
            */
        }
    }

    public static class TestMain {
        public static void main(String[] args) {
            Rectangle rect = new Rectangle();
            rect.setWidth(5);
            rect.setHeight(10);
            System.out.println("Area of Rectangle: " + rect.getArea()); /* 50 */

            Rectangle square = new Square();
            square.setWidth(5);
            square.setHeight(10);
            System.out.println("Area of Square: " + square.getArea()); /* 100, что не ожидается */
        }
    }

}
