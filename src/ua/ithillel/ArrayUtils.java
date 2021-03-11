package ua.ithillel;

import java.util.Arrays;

public class ArrayUtils {

    public static void printObjArray(Object[] objArr) {
        if (objArr.length == 0) {
            System.err.println("Array length is 0!");
            return;
        }

        //System.out.println(Arrays.toString(objArr));

        StringBuilder out = new StringBuilder("["); //
        for (int i = 0; i < objArr.length; i++) {
            if (i == ((objArr.length) - 1)) {
                out.append(objArr[i]).append("]");
            } else {
                out.append(objArr[i]).append(", ");
            }
        }
        System.out.println(out);
    }

    public static void printIntArray(int[] intArr) {
        if (testArr(intArr)) {
            return;
        }

        //System.out.println(Arrays.toString(intArr));

        StringBuilder out = new StringBuilder("[");
        for (int i = 0; i < intArr.length; i++) {
            if (i == ((intArr.length) - 1)) {
                out.append(intArr[i]).append("]");
            } else {
                out.append(intArr[i]).append(", ");
            }
        }
        System.out.println(out);
    }

    public static int[] sortIntArray(int[] intArr) {
        if (testArr(intArr)) {
            return new int[0];
        }

        /*Arrays.sort(intArr);
        return intArr;*/

        //Sorting method: Bubble Sort.
        for (int i = intArr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (intArr[j] > intArr[j + 1]) {
                    int temp = intArr[j];
                    intArr[j] = intArr[j + 1];
                    intArr[j + 1] = temp;
                }
            }
        }
        return intArr;
    }

    public static int[] findMinAndMaxFromIntArray(int[] intArr) {
        if (testArr(intArr)) {
            return new int[0];
        }

        /*int[] minMax = new int[2];
        minMax[0] = Arrays.stream(intArr).min().getAsInt();
        minMax[1] = Arrays.stream(intArr).max().getAsInt();
        return minMax;*/

        int[] minMax = new int[2];
        for (int i : intArr) {
            if (i < minMax[0]) {
                minMax[0] = i;
            } else if (i > minMax[1]) {
                minMax[1] = i;
            }
        }
        return minMax;
    }

    public static String toOneStringInCamelCase(String[] strArr) {
        if (!testArr(strArr)) {
            return null;
        }
        StringBuilder outStr = new StringBuilder();
        if (strArr[0] != null) {
            outStr.append(strArr[0].substring(0, 1).toLowerCase()).append(strArr[0].substring(1));
        }
        for (int i = 1; i < strArr.length; i++) {
            if (strArr[i] != null) {
                outStr.append(strArr[i].substring(0, 1).toUpperCase()).append(strArr[i].substring(1));
            }
        }
        return new String(outStr);
    }

    /**
     * Calculate sum elements in int array.
     *
     * @param intArr the int arr
     * @return the int
     */
    public static int calculateSumElementsInIntArray(int[] intArr) {
        if (testArr(intArr)) {
            return 0;
        }

        //return Arrays.stream(intArr).sum();

        int sum = 0;
        for (int i : intArr) {
            sum += i;
        }
        return sum;
    }

    public static int[] mergeAndSortTwoIntArray(int[] ints1, int[] ints2) {
        /*int[] out = new int[ints1.length + ints2.length];
        System.arraycopy(ints1, 0, out, 0, ints1.length);
        System.arraycopy(ints2, 0, out, ints1.length, ints2.length);
        return ArrayUtils.sortIntArray(out);*/

        int[] result = new int[ints1.length + ints2.length];
        for (int i = 0; i < ints1.length; i++) {
            result[i] = ints1[i];
        }
        for (int i = 0; i < ints2.length; i++) {
            result[ints1.length + i] = ints2[i];
        }
        return ArrayUtils.sortIntArray(result);
    }

    public static int calculateAbsAverageElementValueInIntArray(int[] intArr) {
        if (testArr(intArr)) {
            return 0;
        }

        /*int sum = 0;
        for (int i : intArr) {
            sum += Math.abs(i);
        }
        sum = (sum / intArr.length);
        return sum;*/

        int sum = 0;
        for (int i : intArr) {
            if (i < 0) {
                i = i * (-1);
            }
            sum += i;
        }
        sum = (sum / intArr.length);
        return sum;
    }

    public static int[] removeElementFromIntArray(int i, int[] ints) {
        if (testArr(ints)) {
            return new int[0];
        }

        int newLength = ints.length;
        for (int j = 0; j < ints.length; j++) {
            if (ints[j] == i) {
                newLength--;
            }
        }
        int[] result = new int[newLength];
        int index = 0;
        for (int j = 0; j < ints.length; j++) {
            if (ints[j] != i) {
                result[index] = ints[j];
                index++;
            }
        }
        return result;
    }

    public static int[] generateRandomIntArrayWithSizeMinMax(int size, int min, int max) {
        if (size == 0) {
            System.err.println("Array size is 0.");
            return new int[0];
        }
        int[] out = new int[size];
        for (int i = 0; i < size; i++) {
            out[i] = (int) (Math.random() * (max - min + 1) + min);
        }
        return out;
    }

    private static boolean testArr(int[] arr) {
        if (arr.length == 0) {
            System.err.println("Array length is 0!");
            return true;
        }
        return false;
    }

    private static boolean testArr(String[] arr) {
        if (arr.length == 0) {
            System.err.println("Array length is 0!");
            return false;
        }
        return true;
    }
}