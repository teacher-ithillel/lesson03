package ua.ithillel;

import java.util.Arrays;

public class ArrayUtils {

    public static void printIntArray(int[] intArr) {
        for (int i : intArr) {
            System.out.print(i + " ");
        }
    }

    public static void printObjArray(Object[] objArr) {
        for (Object obj : objArr) {
            System.out.print(obj + " ");
        }
    }

    public static int[] sortIntArray(int[] intArr) {
        for (int i = intArr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (intArr[j] > intArr[j + 1]) {
                    int tmp = intArr[j];
                    intArr[j] = intArr[j + 1];
                    intArr[j + 1] = tmp;
                }
            }
        }
        return intArr;
    }


    public static int[] findMinAndMaxFromIntArray(int[] intArr) {
        int[] newArr = new int[2];
        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] < newArr[0]) {
                newArr[0] = intArr[i];
            }
            if (intArr[i] > newArr[1]) {
                newArr[1] = intArr[i];
            }
        }
        return newArr;
    }

    public static String toOneStringInCamelCase(String[] strArr) {
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                char ch = strArr[i].charAt(0);
                String str = strArr[i].substring(1);
                stb.append(Character.toString(ch).toUpperCase(Locale.ROOT)).append(str);
            } else {
                stb.append(strArr[i]);
            }
        }
        return stb.toString();
    }

    public static int calculateSumElementsInIntArray(int[] intArr) {
        int sum = 0;
        for (int i = 0; i < intArr.length; i++) {
            sum += intArr[i];
        }
        return sum;
    }

    public static int calculateAbsAverageElementValueInIntArray(int[] intArr) {
        int sum = 0;
        for (int i = 0; i < intArr.length; i++) {
            sum += Math.abs(intArr[i]);
        }
        return sum / intArr.length;

    }

    public static int[] mergeAndSortTwoIntArray(int[] ints1, int[] ints2) {
        int[] array = new int[ints1.length + ints2.length];
        for (int i = 0; i < ints1.length; i++) {
            array[i] = ints1[i];
        }
        for (int i = 0; i < ints2.length; i++) {
            array[ints1.length + i] = ints2[i];
        }

        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        return array;
    }

    public static int[] removeElementFromIntArray(int i, int[] ints) {
        int[] array = new int[ints.length - 1];
        for (int j = 0; j < ints.length; j++) {
            if ((ints[j] != i) && (j != array.length)) {
                array[j] = ints[j];
            }

            if ((ints[j] == i) && (j != array.length)) {
                array[j] = ints[j + 1];
                j++;
            }

            if ((ints[j] != i) && (j == array.length)) {
                array[j - 1] = ints[j];
            }
        }
        return array;
    }

    public static int[] generateRandomIntArrayWithSizeMinMax(int size, int min, int max) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = min + (int) (Math.random() * (max - min));
        }
        return array;
    }
}
