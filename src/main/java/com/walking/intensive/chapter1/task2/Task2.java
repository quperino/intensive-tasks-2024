package com.walking.intensive.chapter1.task2;

/**
 * Реализуйте метод getFlatLocation(), который будет принимать параметрами следующие данные:
 * <ul>
 * <li> Количество этажей в доме;
 * <li> Количество подъездов;
 * <li> Номер нужной квартиры.
 * </ul>
 *
 * <p>Необходимо определить подъезд, этаж и расположение нужной квартиры относительно лифта,
 * руководствуясь следующими правилами:
 * <ul>
 * <li> На этаже 4 квартиры;
 * <li> Нумерация квартир возрастает по часовой стрелке.
 * </ul>
 *
 * <p>Примеры строки, возвращаемой из метода:
 * <ul>
 * <li> 1 кв – 1 подъезд, 1 этаж, слева от лифта, влево
 * <li> 2 кв – 1 подъезд, 1 этаж, слева от лифта, вправо
 * <li> 3 кв – 1 подъезд, 1 этаж, справа от лифта, влево
 * <li> 4 кв – 1 подъезд, 1 этаж, справа от лифта, вправо
 * </ul>
 *
 * <p>Если для дома с указанной этажностью и количеством подъездов квартиры с заданным номером не существует,
 * метод должен вернуть строку "Такой квартиры не существует".
 *
 * <p>Если хотя бы один из указанных параметров некорректный - например, отрицательное число или 0,
 * метод должен вернуть строку "Некорректные входные данные".
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task2 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        System.out.println(getFlatLocation(4, 4, 32));
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        //        Место для вашего кода

        // Константы
        final int FLAT_AMOUNT_ON_ONE_FLOOR = 4;
        final int FLAT_AMOUNT_ON_ONE_HOUSE = floorAmount * entranceAmount * FLAT_AMOUNT_ON_ONE_FLOOR;
        final int FLAT_AMOUNT_ON_ONE_ENTRANCE = floorAmount * FLAT_AMOUNT_ON_ONE_FLOOR;

        // Проверка на входные данные
        if (flatNumber > FLAT_AMOUNT_ON_ONE_HOUSE) {
            return "Takoi kvartiry ne seschestvuet.";
        }
        if (floorAmount <= 0 || entranceAmount <= 0 || flatNumber <= 0) {
            return "Nekorrectnye vkhodnye dannye.";
        }

        int flatNumberEquivalent = flatNumber;
        int entranceNumber = 1;

        // Если квартира расположена не в первом подъезде
        if (flatNumber > FLAT_AMOUNT_ON_ONE_ENTRANCE) {
            // Вычисление номера квартиры, эквивалентного относительно первого подъезда + вычисление номера подъезда
            do {
                flatNumberEquivalent -= FLAT_AMOUNT_ON_ONE_ENTRANCE;
                entranceNumber += 1;
            }
            while (flatNumberEquivalent > FLAT_AMOUNT_ON_ONE_ENTRANCE);
        }

        int floorNumber;

        // Если квартира имеет номер, не кратный 4
        if (flatNumberEquivalent % 4 != 0) {
            // Вычисление этажа
            floorNumber = flatNumberEquivalent / 4 + 1;
        } else {
            floorNumber = flatNumberEquivalent / 4;
        }

        // Если квартира расположена не на первом этаже
        if (floorNumber > 1) {
            // Вычисление расположения квартиры, относительно первого этажа
            do {
                flatNumberEquivalent -= FLAT_AMOUNT_ON_ONE_FLOOR;
            }
            while (flatNumberEquivalent > FLAT_AMOUNT_ON_ONE_FLOOR);
        }

        String flatLocationOnAFloor = switch (flatNumberEquivalent) {
            case 1 -> "sleva ot lifta, vlevo";
            case 2 -> "sleva ot lifta, vpravo";
            case 3 -> "sprava ot lifta, vlevo";
            default -> "sprava ot lifta, vpravo";
        };

        return flatNumber + " kv - " + entranceNumber + " pod_ezd, " + floorNumber + " etazh, " + flatLocationOnAFloor;
    }
}