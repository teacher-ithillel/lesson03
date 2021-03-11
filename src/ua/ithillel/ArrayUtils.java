package ua.ithillel;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtils {

    public static void printObjArray(Object[] objArr) {
        for (Object s : objArr) {
            System.out.println(s);
        }
    }

    public static void printIntArray(int[] intArr) {
        for (int s : intArr) {
            System.out.println(s);
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
        int[] temp = sortIntArray(intArr);
        int firstNum = temp[0];
        int lastNum = temp[temp.length - 1];


        return new int[]{firstNum, lastNum};

    }

    public static String toOneStringInCamelCase(String[] strArr) {

        String camelCaseString = "";
        for (String part : strArr) {
            camelCaseString = camelCaseString + toProperCase(part);
        }
        return camelCaseString;
    }

    private static String toProperCase(String s) {
        return s.substring(0, 1).toUpperCase() +
                s.substring(1).toLowerCase();
    }

    public static int calculateSumElementsInIntArray(int[] intArr) {
        int sum = 0;
        for (int value : intArr) {
            sum += value;
        }
        return sum;
    }

    public static int[] mergeAndSortTwoIntArray(int[] ints1, int[] ints2) {
        int[] answer = new int[ints1.length + ints2.length];
        int i = 0, j = 0, k = 0;
        while (i < ints1.length && j < ints2.length) {
            if (ints1[i] < ints2[j]) {
                answer[k] = ints1[i];
                i++;
            } else {
                answer[k] = ints2[j];
                j++;
            }
            k++;
        }
        while (i < ints1.length) {
            answer[k] = ints1[i];
            i++;
            k++;
        }
        while (j < ints2.length) {
            answer[k] = ints2[j];
            j++;
            k++;
        }
        return sortIntArray(answer);
    }

    /**
     * calculate abs average element value in int array
     *
     * @param intArr - This Array integer
     * @return calculate element value in int array
     */
    public static int calculateAbsAverageElementValueInIntArray(int[] intArr) {
        int result = 0;
        for (int value : intArr) {
            result = result + Math.abs(value);
        }
        return result / intArr.length;
    }

    public static int[] removeElementFromIntArray(int i, int[] ints) {
        int[] copy = new int[ints.length - 1];

        for (int a = 0, j = 0; a < ints.length; a++) {
            if (ints[a] != i) {
                copy[j++] = ints[a];
            }
        }
        return copy;
    }

    public static int[] generateRandomIntArrayWithSizeMinMax(int size, int min, int max) {
        int array[] = new int[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.ints(min, max).findFirst().getAsInt();
        }
        return array;
    }
}
