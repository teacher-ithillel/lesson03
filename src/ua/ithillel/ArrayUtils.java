package ua.ithillel;

import java.util.Arrays;

public class ArrayUtils {
    /*javadoc
    Один из самых известных алгоритмов сортировки,
    реализовать который часто просят на технических собеседованиях.
    В этом алгоритме массив перебирается раз за разом, и каждое следующее значение сравнивается с предыдущим.
    После первого прохода по массиву самое большое число окажется в конце, а когда первый элемент будет не с чем сравнить,
    массив будет отсортирован по возрастанию.
     */
    public static void printObjArray(Object[] objArr) {
        System.out.println(Arrays.toString(objArr));
    }

    public static void printIntArray(int[] intArr) {

        System.out.println(Arrays.toString(intArr));
    }

    public static int[] sortIntArray(int[] intArr) {
        int povtoriv = 0;//кількість повторів
        boolean zamina = true;//
        while (zamina) {
            zamina = false;// означае що масив відсортовано
            for (int i = 0; i < intArr.length - 1 - povtoriv; i++) {// віднімаю к-сть повторів щоб цикл не проходив до кінця так як найбільший елемент гарантовано після першого пробігу стане останім
                if (intArr[i] > intArr[i + 1]) {// порівнюю сусідні елемнти
                    int tmp = intArr[i];// tmp тимчасова змінна для перестановки елеметів
                    intArr[i] = intArr[i + 1];
                    intArr[i + 1] = tmp;
                    zamina = true;// кажу що заміна відбулась
                }
            }
            povtoriv++;
        }

        return intArr;
    }

    public static int[] findMinAndMaxFromIntArray(int[] intArr) {
        Arrays.sort(intArr);
        return new int[]{intArr[0], intArr[intArr.length - 1]};

    }

    public static String toOneStringInCamelCase(String[] strArr) {

        return null;

    }

    public static int calculateSumElementsInIntArray(int[] intArr) {
        int sum = 0;
        for (int i = 0; i < intArr.length; i++) {
            sum += intArr[i];
        }
        return sum;
    }

    public static int[] mergeAndSortTwoIntArray(int[] ints1, int[] ints2) {
        int ints1Length = ints1.length;
        int inst2Length = ints2.length;

        int[] merged = new int[ints1Length + inst2Length];

        int ints1Position, ints2Position, mergedPosition;
        ints1Position = ints2Position = mergedPosition = 0;

        while (ints1Position < ints1Length && ints2Position < inst2Length) {// прохожусь по обом масивам і беру масив який має елемент з меншим значееням свого індексу
            if (ints1[ints1Position] < ints2[ints2Position]) {
                merged[mergedPosition++] = ints1[ints1Position++];
            } else {
                merged[mergedPosition++] = ints2[ints2Position++];
            }
        }

        while (ints1Position < ints1Length) {// копіюю залишені елементи
            merged[mergedPosition++] = ints1[ints1Position++];
        }

        while (ints2Position < inst2Length) {// копіюю залишені елементи
            merged[mergedPosition++] = ints2[ints2Position++];
        }

        return merged;
    }


    public static int calculateAbsAverageElementValueInIntArray(int[] intArr) {
        if (intArr == null)
            return 0;

        int sum = 0;
        int n = 0;

        for (int i = 0; i < intArr.length; i++)
            if (intArr[i] > 0) {
                sum += intArr[i];
                n++;
            }

        return (sum / n);

    }

    public static int[] removeElementFromIntArray(int i, int[] ints) {
        int[] Array = new int[ints.length - 1];

        for (int k = 0, j = 0; k < ints.length; k++) {
            if (ints[k] == i) {
                ints[k] = 0;

            } else {
                Array[j++] = ints[k];
            }
        }
        return Array;
    }


    public static int[] generateRandomIntArrayWithSizeMinMax(int size, int min, int max) {
        int[] result = new int[size];

        for (int i = 0; i < result.length; i++) {
            result[i] = (int) ((Math.random() * (max - min)) + min);
        }

        return result;
    }


}