package org.example.Homework.HW11;

import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Calculator {
    private static final Logger logger = Logger.getLogger(Calculator.class.getName());
    private static FileHandler fileHandler;

    static {
        try {
            fileHandler = new FileHandler("calculator.log");
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void logInfo(String message) {
        logger.log(Level.INFO, message);
    }

    private static void logError(String message) {
        logger.log(Level.SEVERE, message);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Выберите операцию:");
            System.out.println("1. Сложение");
            System.out.println("2. Вычитание");
            System.out.println("3. Умножение");
            System.out.println("4. Деление");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performAddition(scanner);
                    break;
                case 2:
                    performSubtraction(scanner);
                    break;
                case 3:
                    performMultiplication(scanner);
                    break;
                case 4:
                    performDivision(scanner);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Некорректный выбор операции.");
                    logError("Некорректный выбор операции.");
                    break;
            }
        }

        fileHandler.close();
    }

    private static void performAddition(Scanner scanner) {
        System.out.println("Введите первое число (в формате a+bi или a для рациональных чисел):");
        String input1 = scanner.next();
        System.out.println("Введите второе число (в формате a+bi или a для рациональных чисел):");
        String input2 = scanner.next();

        Number num1 = Number.parseNumber(input1);
        Number num2 = Number.parseNumber(input2);

        if (num1 != null && num2 != null) {
            Number result = num1.add(num2);
            System.out.println("Результат: " + result);
            logInfo("Выполнено сложение: " + num1 + " + " + num2 + " = " + result);
        } else {
            System.out.println("Ошибка ввода чисел.");
            logError("Ошибка ввода чисел.");
        }
    }

    private static void performSubtraction(Scanner scanner) {
        System.out.println("Введите первое число (в формате a + bi или a для рациональных чисел):");
        String input1 = scanner.next();
        System.out.println("Введите второе число (в формате a + bi или a для рациональных чисел):");
        String input2 = scanner.next();

        Number num1 = Number.parseNumber(input1);
        Number num2 = Number.parseNumber(input2);

        if (num1 != null && num2 != null) {
            Number result = num1.subtract(num2);
            System.out.println("Результат: " + result);
            logInfo("Выполнено вычитание: " + num1 + " - " + num2 + " = " + result);
        } else {
            System.out.println("Ошибка ввода чисел.");
            logError("Ошибка ввода чисел.");
        }
    }

    private static void performMultiplication(Scanner scanner) {
        System.out.println("Введите первое число (в формате a + bi или a для рациональных чисел):");
        String input1 = scanner.next();
        System.out.println("Введите второе число (в формате a + bi или a для рациональных чисел):");
        String input2 = scanner.next();

        Number num1 = Number.parseNumber(input1);
        Number num2 = Number.parseNumber(input2);

        if (num1 != null && num2 != null) {
            Number result = num1.multiply(num2);
            System.out.println("Результат: " + result);
            logInfo("Выполнено умножение: " + num1 + " * " + num2 + " = " + result);
        } else {
            System.out.println("Ошибка ввода чисел.");
            logError("Ошибка ввода чисел.");
        }
    }

    private static void performDivision(Scanner scanner) {
        System.out.println("Введите первое число (в формате a + bi или a для рациональных чисел):");
        String input1 = scanner.next();
        System.out.println("Введите второе число (в формате a + bi или a для рациональных чисел):");
        String input2 = scanner.next();

        Number num1 = Number.parseNumber(input1);
        Number num2 = Number.parseNumber(input2);

        if (num1 != null && num2 != null) {
            if (!num2.isZero()) {
                Number result = num1.divide(num2);
                System.out.println("Результат: " + result);
                logInfo("Выполнено деление: " + num1 + " / " + num2 + " = " + result);
            } else {
                System.out.println("Ошибка: деление на ноль.");
                logError("Ошибка: деление на ноль.");
            }
        } else {
            System.out.println("Ошибка ввода чисел.");
            logError("Ошибка ввода чисел.");
        }
    }
}
