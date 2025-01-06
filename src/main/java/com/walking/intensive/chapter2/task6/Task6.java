package com.walking.intensive.chapter2.task6;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */

public class Task6 {
    public static void main(String[] args) {
        System.out.println(getLcm(30, 160));
        System.out.println(getGcd(30, 160));
        System.out.println(getGcdByEuclideanAlgorithm(30, 160));
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

        if (m <= 0 || n <= 0) {
            return lcm;
        }

        int minNumber = Math.min(m, n);
        int maxNumber = Math.max(m, n);
        lcm = maxNumber;
        int[] minNumberFactors = getNumberFactors(minNumber);
        int[] maxNumberFactors = getNumberFactors(maxNumber);

        int[] uniqueNumbersMin = getUniqueNumbers(minNumberFactors);

        for (int uniqueNumber : uniqueNumbersMin) {
            int maxCounter = 0;
            int minCounter = 0;

            boolean isContains = false;

            for (int i : maxNumberFactors) {
                if (i == uniqueNumber) {
                    isContains = true;
                    break;
                }
            }

            if (isContains) {
                for (int array : maxNumberFactors) {
                    if (uniqueNumber == array) {
                        maxCounter++;
                    }
                }
            }

            isContains = false;

            for (int i : minNumberFactors) {
                if (i == uniqueNumber) {
                    isContains = true;
                    break;
                }
            }

            if (isContains) {
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

        if (m <= 0 || n <= 0) {
            return gcd;
        }

        int[] numberFactorsForM = getNumberFactors(m);
        int[] numberFactorsForN = getNumberFactors(n);
        gcd = 1;

        int[] uniqueNumbersForM = getUniqueNumbers(numberFactorsForM);

        for (int uniqueNumberForM : uniqueNumbersForM) {
            int counterForM = 0;
            int counterForN = 0;

            boolean isContains = false;

            for (int i : numberFactorsForM) {
                if (i == uniqueNumberForM) {
                    isContains = true;
                    break;
                }
            }

            if (isContains) {
                for (int array : numberFactorsForM) {
                    if (uniqueNumberForM == array) {
                        counterForM++;
                    }
                }
            } else {
                continue;
            }

            isContains = false;

            for (int i : numberFactorsForN) {
                if (i == uniqueNumberForM) {
                    isContains = true;
                    break;
                }
            }

            if (isContains) {
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
        if (m <= 0 || n <= 0) {
            return gcd;
        }

        gcd = getGcdByEuclideanAlgorithmCalculation(m, n);
        return gcd;
    }


    // Custom methods

    static int[] getNumberFactors(int number) {
        int k = 2;
        int arrayLength = 0;
        int numberBackUp = number;

        while (number != 1) {
            if (number % k == 0) {

                arrayLength++;
                number = number / k;
                k = 2;

            } else {
                k++;
            }
        }

        int[] numbersFactors = new int[arrayLength];

        int i = -1;
        while (numberBackUp != 1) {
            if (numberBackUp % k == 0) {
                i++;
                numbersFactors[i] = k;
                numberBackUp = numberBackUp / k;
                k = 2;

            } else {
                k++;
            }
        }

        return numbersFactors;
    }

    static int[] getUniqueNumbers(int[] array) {
        int k = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1]) {
                k++;
            }
        }

        int[] uniqueNumbers = new int[k];
        k = 0;
        uniqueNumbers[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1]) {
                k++;
                uniqueNumbers[k] = array[i];
            }
        }

        return uniqueNumbers;
    }

    static int getGcdByEuclideanAlgorithmCalculation(int m, int n) {
        if (n == 0) {
            return m;
        }

        return getGcdByEuclideanAlgorithmCalculation(n, m % n);

    }
}
