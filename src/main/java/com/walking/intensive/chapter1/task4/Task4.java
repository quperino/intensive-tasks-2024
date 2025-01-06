package com.walking.intensive.chapter1.task4;

/**
 * Дано уравнение:
 *
 * <p>ax² + bx + c = 0
 *
 * <p>Реализуйте метод solveEquation(), который параметрами принимает
 * коэффициенты - вещественные числа a, b и c.
 *
 * <p>Метод должен возвращать в виде строки количество решений, а также сами решения в указанном ниже формате:
 * <ul>
 * <li> "Количество решений: 2. Корни: -4;4"
 * <li> "Количество решений: 1. Корень: 0"
 * <li> "Количество решений: 0."
 * <li> "Бесконечное множество решений."
 * </ul>
 *
 * <p>Обратите внимание, что если корней уравнения два - они должны располагаться по возрастанию.
 *
 * <p>P.S. Квадратные уравнения решаются либо через теорему Виета, либо через дискриминант.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task4 {
    public static void main(String[] args) {
        double a = -1;
        double b = -3;
        double c = 0;
        System.out.println(solveEquation(a, b, c));
    }

    static String solveEquation(double a, double b, double c) {
        String s;

        if (a == 0 && b == 0 && c == 0) {
            s = "Бесконечное множество решений.";
        } else if (a == 0 && b == 0 || a > 0 && c > 0 && b == 0 || a < 0 && c < 0 && b == 0 || b * b < 4 * a * c) {
            s = "Количество решений: 0.";
        } else if (a == 0 && c == 0 || b == 0 && c == 0) {
            s = "Количество решений: 1. Корень: 0";
        } else if (a == 0 && b < 0 && c < 0 || a == 0 && b < 0 && c > 0 || a == 0 && b > 0 && c < 0 || a == 0 && b > 0 && c > 0){
            s = "Количество решений: 1. Корень: " + -c / b;
        } else if (b * b == 4 * a * c) {
            s = "Количество решений: 1. Корень: " + -b / 2 * a;
        } else if (a > 0 && c < 0 || a < 0 && c > 0) {
            double x1 = Math.sqrt(c / a);
            double x2 = -Math.sqrt(c / a);
            s = "Количество решений: 2. Корни: " + Math.min(x1, x2) + ";" + Math.max(x1, x2);
        } else if (a != 0 && b != 0 && c == 0) {
            s = "Количество решений: 2. Корни: " + Math.min(0, -b / a) + ";" + Math.max(0, -b / a);
        } else {
            double x1 = (-b + Math.sqrt(b * b - 4 * a * c)) / 2 * a;
            double x2 = (-b - Math.sqrt(b * b - 4 * a * c)) / 2 * a;
            s = "Количество решений: 2. Корни: " + Math.min(x1, x2) + ";" + Math.max(x1, x2);
        }

        return s;
    }
}
