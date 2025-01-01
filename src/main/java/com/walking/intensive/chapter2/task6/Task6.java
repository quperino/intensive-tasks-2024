package com.walking.intensive.chapter2.task6;

import java.util.Arrays;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {
        System.out.println(getLcm(70, 140));
        System.out.println(getGcd(70, 0));
        System.out.println(getGcdByEuclideanAlgorithm(70, 140));
    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getLcm(int m, int n) {
        int lcm = -1;

        if (m > 0 && n > 0) {
            int minNumber = Math.min(m, n);
            int maxNumber = Math.max(m, n);
            lcm = maxNumber;
            int[] minNumberFactors = getNumberFactors(minNumber);
            int[] maxNumberFactors = getNumberFactors(maxNumber);

            int[] uniqueNumbers = Arrays.stream(minNumberFactors).distinct().toArray();

            for (int uniqueNumber : uniqueNumbers) {
                int maxCounter = 0;
                int minCounter = 0;

                if (Arrays.asList(Arrays.stream(maxNumberFactors).boxed().toArray()).contains(uniqueNumber)) {
                    for (int array : maxNumberFactors) {
                        if (uniqueNumber == array) {
                            maxCounter++;
                        }
                    }
                }

                if (Arrays.asList(Arrays.stream(minNumberFactors).boxed().toArray()).contains(uniqueNumber)) {
                    for (int array : minNumberFactors) {
                        if (uniqueNumber == array) {
                            minCounter++;
                        }
                    }
                }

                if (minCounter > maxCounter) {
                    lcm *= (int) Math.pow(uniqueNumber, (minCounter - maxCounter));
                }

            }
        }

        return lcm;
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcd(int m, int n) {
        int gcd = -1;

        if (m > 0 && n > 0) {
            int[] numberFactorsForM = getNumberFactors(m);
            int[] numberFactorsForN = getNumberFactors(n);
            gcd = 1;

            int[] uniqueNumbersForM = Arrays.stream(numberFactorsForM).distinct().toArray();

            for (int uniqueNumberForM : uniqueNumbersForM) {
                int counterForM = 0;
                int counterForN = 0;

                if (Arrays.asList(Arrays.stream(numberFactorsForM).boxed().toArray()).contains(uniqueNumberForM)) {
                    for (int array : numberFactorsForM) {
                        if (uniqueNumberForM == array) {
                            counterForM++;
                        }
                    }
                } else {
                    continue;
                }

                if (Arrays.asList(Arrays.stream(numberFactorsForN).boxed().toArray()).contains(uniqueNumberForM)) {
                    for (int array : numberFactorsForN) {
                        if (uniqueNumberForM == array) {
                            counterForN++;
                        }
                    }
                } else {
                    continue;
                }

                int minOfCounters = Math.min(counterForM, counterForN);
                gcd *= (int) Math.pow(uniqueNumberForM, minOfCounters);
            }
        }

        return gcd;
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     * Расчет должен производиться с помощью рекурсивной версии алгоритма Евклида.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcdByEuclideanAlgorithm(int m, int n) {
        int gcd = -1;

        if (m > 0 && n > 0) {
            int minNumber = Math.min(m, n);
            int maxNumber = Math.max(m, n);
            gcd = minNumber;
            int maxNumberBuffer;

            while (minNumber != 0) {
                if (maxNumber % minNumber != 0) {
                    gcd = maxNumber % minNumber;
                }
                maxNumberBuffer = maxNumber;
                maxNumber = minNumber;
                minNumber = maxNumberBuffer % minNumber;
            }
        }

        return gcd;
    }

    static int[] getNumberFactors(int number) {
        StringBuilder numberFactorsStringBuilder = new StringBuilder();
        int k = 2;

        while (number != 1) {

            if (number % k == 0) {

                numberFactorsStringBuilder.append(k).append(";");
                number = number / k;
                k = 2;

            } else {
                k++;
            }
        }

        String numberFactorsString = numberFactorsStringBuilder.toString();
        String[] numberFactorsStringArray = numberFactorsString.split(";");
        int[] numberFactorsInt = new int[numberFactorsStringArray.length];

        for (int i = 0; i < numberFactorsStringArray.length; i++) {
            numberFactorsInt[i] = Integer.parseInt(numberFactorsStringArray[i]);
        }

        return numberFactorsInt;
    }
}
