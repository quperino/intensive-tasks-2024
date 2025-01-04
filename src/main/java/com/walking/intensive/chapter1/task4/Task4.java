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
        double a = 4;
        double b = 4;
        double c = 1;
        System.out.println(solveEquation(a, b, c));
    }

    static String solveEquation(double a, double b, double c) {
        String s;

        if (a == 0 && b == 0 && c == 0) {
            s = "Бесконечное множество решений.";
        } else if (b * b < 4 * a * c) {
            s = "Количество решений: 0.";
        } else if (b * b == 4 * a * c) {
            s = "Количество решений: 1. Корень: " + (-c / b);
        } else {
            double discriminant = (Math.pow(b, 2)) - (4 * a * c);
            double x1 = (-b - Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b + Math.sqrt(discriminant)) / (2 * a);
            if (x1 > x2) {
                s = "Количество решений: 2. Корни: " + x2 + ";" + x1;
            } else {
                s = "Количество решений: 2. Корни: " + x1 + ";" + x2;
            }
        }

        return s;
    }
}
