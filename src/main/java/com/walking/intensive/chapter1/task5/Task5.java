package com.walking.intensive.chapter1.task5;

import java.util.Arrays;

/**
 * Задача поиска площади, величин углов, длин высот, биссектрис, медиан, радиусов вписанной и описанной вокруг
 * треугольника окружностей является центральной в Геометрии.
 *
 * <p>Реализуйте представленные ниже методы в соответствии с заданными условиями.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */

public class Task5 {
    public static void main(String[] args) {
        System.out.println(getAreaByHeron(2, 3, 4) + "\n");
        double[] arrayForHeights = getHeights(2, 2, 3);
        for (int i = 0; i < 3; i++) {
            System.out.println(arrayForHeights[i]);
        }
        System.out.println();
        double[] arrayForMedians = getMedians(2, 3, 4);
        for (int i = 0; i < 3; i++) {
            System.out.println(arrayForMedians[i]);
        }
        System.out.println();
        double[] arrayForBisectors = getBisectors(2, 3, 4);
        for (int i = 0; i < 3; i++) {
            System.out.println(arrayForBisectors[i]);
        }
        System.out.println();
        double[] arrayForAngles = getAngles(2, 3, 4);
        for (int i = 0; i < 3; i++) {
            System.out.println(arrayForAngles[i]);
        }
        System.out.println();
        System.out.println(getInscribedCircleRadius(2, 3, 4) + "\n");
        System.out.println(getCircumradius(2, 3, 4) + "\n");
        System.out.println(getAreaAdvanced(2, 3, 4));
    }

    /**
     * Частным случаем Tеоремы Брахмагупты является формула Герона.
     *
     * <p>Реализуйте метод поиска площади треугольника формулой Герона.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - площадь треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */

    static double getAreaByHeron(double a, double b, double c) {
        double areaByHeron = -1;

        if (doesTriangleNotExist(a, b, c)) {
            return areaByHeron;
        }

        double semiperimeter = getSemiperimeter(a, b, c);
        areaByHeron = Math.sqrt(semiperimeter * (semiperimeter - a) * (semiperimeter - b) * (semiperimeter - c));

        return areaByHeron;
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */

    static double[] getHeights(double a, double b, double c) {
        double[] heights = new double[0];

        if (doesTriangleNotExist(a, b, c)) {
            return heights;
        }

        heights = new double[]{2 * getAreaByHeron(a, b, c) / a, 2 * getAreaByHeron(a, b, c) / b, 2 * getAreaByHeron(a, b, c) / c};
        Arrays.sort(heights);

        return heights;
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */

    static double[] getMedians(double a, double b, double c) {
        double[] medians = new double[0];

        if (doesTriangleNotExist(a, b, c)) {
            return medians;
        }

        medians = new double[]{Math.sqrt(2 * b * b + 2 * c * c - a * a) / 2, Math.sqrt(2 * a * a + 2 * c * c - b * b) / 2, Math.sqrt(2 * a * a + 2 * b * b - c * c) / 2};
        Arrays.sort(medians);

        return medians;
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        double[] bisectors = new double[0];

        if (doesTriangleNotExist(a, b, c)) {
            return bisectors;
        }

        bisectors = new double[]{Math.sqrt(b * c * (a + b + c) * (b + c - a)) / (b + c), Math.sqrt(a * c * (a + b + c) * (a + c - b)) / (a + c), Math.sqrt(a * b * (a + b + c) * (a + b - c)) / (a + b)};
        Arrays.sort(bisectors);

        return bisectors;
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        double[] angles = new double[0];

        if (doesTriangleNotExist(a, b, c)) {
            return angles;
        }

        angles = new double[]{Math.acos((a * a + b * b - c * c) / 2 * a * b) * 180 / Math.PI, Math.acos((a * a + c * c - b * b) / 2 * a * c) * 180 / Math.PI, Math.acos((b * b + c * c - a * a) / 2 * b * c) * 180 / Math.PI};
        Arrays.sort(angles);

        return angles;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        double inscribedCircleRadius = -1;

        if (doesTriangleNotExist(a, b, c)) {
            return inscribedCircleRadius;
        }

        inscribedCircleRadius = Math.sqrt(getAreaByHeron(a, b, c) / getSemiperimeter(a, b, c) / getSemiperimeter(a, b, c));

        return inscribedCircleRadius;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        double circumradius = -1;

        if (doesTriangleNotExist(a, b, c)) {
            return circumradius;
        }

        circumradius = a * b * c / 4 / getAreaByHeron(a, b, c);

        return circumradius;
    }

    /**
     * Дополнительная задача по желанию.
     *
     * <p>Реализуйте метод, который будет возвращать площадь треугольника.
     *
     * <p>Расчет площади должен быть произведем через поиск косинуса угла через теорему косинусов,
     * далее нахождение синуса через основное тригонометрическое тождество
     * и подстановку синуса в нужную формулу для площади треугольника.
     * (Всего основных способов поиска площади треугольника 6)
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaAdvanced(double a, double b, double c) {
        double area = -1;

        if (doesTriangleNotExist(a, b, c)) {
            return area;
        }

        double sinAngleBC = Math.sqrt(1 - ((b * b + c * c - a * a) / 2 * b * c));
        area = b * c * sinAngleBC / 2;

        return area;
    }

    static boolean doesTriangleNotExist(double a, double b, double c) {
        return !(a > 0) || !(b > 0) || !(c > 0) || !(a + b > c) || !(a + c > b) || !(b + c > a);
    }

    static double getSemiperimeter(double a, double b, double c) {
        return (a + b + c) / 2;
    }
}
