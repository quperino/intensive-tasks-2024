package com.walking.intensive.chapter2.task8;

/**
 * Добираясь в школу на трамвае Вова проверяет, является ли купленный билет счастливым.
 * Если является, то нужно загадать желание и съесть билетик.
 *
 * <p>Билет содержит 6 цифр, комбинации подбираются случайным образом от 000000 до 999999.
 *
 * <p>Билет считается счастливым, если сумма первых трех цифр равна сумме последних трех цифр.
 *
 * <p>Пример: 123411 – счастливый (1 + 2 + 3 == 4 + 1 + 1).
 *
 * <p>Реализуйте метод getHappyTicketChance(), который будет возвращать вероятность
 * выпадения счастливого билета.
 *
 * <p>P.S. Вероятность – это отношение благоприятных исходов к числу всех исходов.
 * Вероятность не может принимать значение больше 1.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */

public class Task8 {
    public static void main(String[] args) {
        System.out.println(getHappyTicketChance());
    }

    static double getHappyTicketChance() {
        int happyTicketCounter = 0;
        int[] array = new int[6];

        for (int i = 0; i <= 999_999; i++) {
            int k = i;
            int leftNumbersSum = 0;
            int rightNumbersSum = 0;

            for (int j = 5; j >= 0; j--) {
                array[j] = k % 10;
                k /= 10;

                if (j > 2) rightNumbersSum += array[j];
                else leftNumbersSum += array[j];
            }

            if (leftNumbersSum == rightNumbersSum) happyTicketCounter++;
        }

        return (double) happyTicketCounter / 1_000_000;
    }
}
