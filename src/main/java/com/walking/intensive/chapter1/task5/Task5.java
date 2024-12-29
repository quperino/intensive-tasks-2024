package com.walking.intensive.chapter1.task5;

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

        if (isTriangleExist(a, b, c)) {
            double semiperimeter = (a + b + c) / 2;
            areaByHeron = Math.sqrt(semiperimeter * (semiperimeter - a) * (semiperimeter - b) * (semiperimeter - c));
        }

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

        if (isTriangleExist(a, b, c)) {
            double semiperimeter = (a + b + c) / 2;
            double heightTo = 2 * Math.sqrt(semiperimeter * (semiperimeter - a) * (semiperimeter - b) * (semiperimeter - c));
            double heightToA = heightTo / a;
            double heightToB = heightTo / b;
            double heightToC = heightTo / c;

            double maxHeight = Math.max(Math.max(heightToA, heightToB), heightToC);
            double minHeight = Math.min(Math.min(heightToA, heightToB), heightToC);
            double averageHeight;

            if (heightToA != minHeight && heightToA != maxHeight) {
                averageHeight = heightToA;
            } else if (heightToB != minHeight && heightToB != maxHeight) {
                averageHeight = heightToB;
            } else {
                averageHeight = heightToC;
            }

            heights = new double[]{minHeight, averageHeight, maxHeight};
        }

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

        if (isTriangleExist(a, b, c)) {
            double medianToA = Math.sqrt(2 * b * b + 2 * c * c - a * a) / 2;
            double medianToB = Math.sqrt(2 * a * a + 2 * c * c - b * b) / 2;
            double medianToC = Math.sqrt(2 * a * a + 2 * b * b - c * c) / 2;

            double maxMedian = Math.max(Math.max(medianToA, medianToB), medianToC);
            double minMedian = Math.min(Math.min(medianToA, medianToB), medianToC);
            double averageMedian;

            if (medianToA != minMedian && medianToA != maxMedian) {
                averageMedian = medianToA;
            } else if (medianToB != minMedian && medianToB != maxMedian) {
                averageMedian = medianToB;
            } else {
                averageMedian = medianToC;
            }

            medians = new double[]{minMedian, averageMedian, maxMedian};
        }

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

        if (isTriangleExist(a, b, c)) {
            double bisectorToA = Math.sqrt(b * c * (a + b + c) * (b + c - a)) / (b + c);
            double bisectorToB = Math.sqrt(a * c * (a + b + c) * (a + c - b)) / (a + c);
            double bisectorToC = Math.sqrt(a * b * (a + b + c) * (a + b - c)) / (a + b);

            double maxBisector = Math.max(Math.max(bisectorToA, bisectorToB), bisectorToC);
            double minBisector = Math.min(Math.min(bisectorToA, bisectorToB), bisectorToC);
            double averageBisector;

            if (bisectorToA != minBisector && bisectorToA != maxBisector) {
                averageBisector = bisectorToA;
            } else if (bisectorToB != minBisector && bisectorToB != maxBisector) {
                averageBisector = bisectorToB;
            } else {
                averageBisector = bisectorToC;
            }

            bisectors = new double[]{minBisector, averageBisector, maxBisector};
        }

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

        if (isTriangleExist(a, b, c)) {
            double cosAngleAB = (a * a + b * b - c * c) / 2 * a * b;
            double cosAngleAC = (a * a + c * c - b * b) / 2 * a * c;
            double cosAngleBC = (b * b + c * c - a * a) / 2 * b * c;

            double angleAB = Math.acos(cosAngleAB) * 180 / Math.PI;
            double angleAC = Math.acos(cosAngleAC) * 180 / Math.PI;
            double angleBC = Math.acos(cosAngleBC) * 180 / Math.PI;

            double maxAngle = Math.max(Math.max(angleAC, angleAB), angleBC);
            double minAngle = Math.min(Math.min(angleAC, angleAB), angleBC);
            double averageAngle;

            if (angleAB != minAngle && angleAB != maxAngle) {
                averageAngle = angleAB;
            } else if (angleAC != minAngle && angleAC != maxAngle) {
                averageAngle = angleAC;
            } else {
                averageAngle = angleBC;
            }

            angles = new double[]{minAngle, averageAngle, maxAngle};
        }

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

        if (isTriangleExist(a, b, c)) {
            double semiperimeter = (a + b + c) / 2;
            inscribedCircleRadius = Math.sqrt((semiperimeter - a) * (semiperimeter - b) * (semiperimeter - c) / semiperimeter);
        }

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

        if (isTriangleExist(a, b, c)) {
            double semiperimeter = (a + b + c) / 2;
            circumradius = a * b * c / 4 * Math.sqrt(semiperimeter * (semiperimeter - a) * (semiperimeter - b) * (semiperimeter - c));
        }

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

        if (isTriangleExist(a, b, c)) {
            double cosAngleBC = (b * b + c * c - a * a) / 2 * b * c;
            double sinAngleBC = Math.sqrt(1 - cosAngleBC);
            area = b * c * sinAngleBC / 2;
        }

        return area;
    }

    static boolean isTriangleExist(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0 && a + b > c && a + c > b && b + c > a;
    }

}
