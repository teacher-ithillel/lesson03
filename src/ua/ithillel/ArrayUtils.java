package ua.ithillel;

public class ArrayUtils {

    public static void printObjArray(Object[] objArr) {
        StringBuilder objArrayToPrint = new StringBuilder();
        objArrayToPrint.append("[");
        for (int i = 0; i < objArr.length; i++) {
            objArrayToPrint.append(objArr[i]);
            if (i != objArr.length - 1) {
                objArrayToPrint.append(", ");
            }
        }
        objArrayToPrint.append("]");
        System.out.println(objArrayToPrint);
    }

    public static void printIntArray(int[] intArr) {
        StringBuilder intArrayToPrint = new StringBuilder();
        intArrayToPrint.append("[");
        for (int i = 0; i < intArr.length; i++) {
            intArrayToPrint.append(intArr[i]);
            if (i != intArr.length - 1) {
                intArrayToPrint.append(", ");
            }
        }
        intArrayToPrint.append("]");
        System.out.println(intArrayToPrint);
    }

    public static int[] sortIntArray(int[] intArr) {
        int min = 0;
        int high = intArr.length - 1;
        sort(intArr, min, high);

        return intArr;
    }

    public static int[] findMinAndMaxFromIntArray(int[] intArr) {
        int max = 0;
        int min = 0;
        for (int value : intArr) {
            if (value <= min) {
                min = value;
            }
            if (value >= max) {
                max = value;
            }
        }
        return new int[]{min, max};
    }

    /**
     * Метод toOneStringInCamelCase принимает массив строк
     *
     * @return возвращает строку в CamelCase
     */
    public static String toOneStringInCamelCase(String[] strArr) {
        StringBuilder stringInCamelCase = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            if (i == 0) {
                stringInCamelCase.append(strArr[i].substring(0, 1).toLowerCase()).append(strArr[i].substring(1));
            } else {
                stringInCamelCase.append(strArr[i].substring(0, 1).toUpperCase()).append(strArr[i].substring(1));
            }
        }
        return stringInCamelCase.toString();
    }

    private static void sort(int[] intArr, int low, int high) {
        if (intArr.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        int oporniy = intArr[middle];

        int i = low;
        int j = high;

        while (i <= j) {
            while (intArr[i] < oporniy) {
                i++;
            }
            while (intArr[j] > oporniy) {
                j--;
            }

            if (i <= j) {
                int temp = intArr[i];
                intArr[i] = intArr[j];
                intArr[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            sort(intArr, low, j);

        if (high > i)
            sort(intArr, i, high);
    }

    public static int calculateSumElementsInIntArray(int[] intArr) {
        int sum = 0;
        for (int num : intArr) {
            sum += num;
        }
        return sum;
    }

    public static int[] mergeAndSortTwoIntArray(int[] ints1, int[] ints2) {
        // merge ints1 + inst2
        int[] merged = new int[ints1.length + ints2.length];
        int index = 0;
        for (int i = 0; i < ints1.length; i++) {
            index = i;
            merged[i] = ints1[i];
        }
        if (index == ints1.length - 1) {
            for (int i : ints2) {
                merged[index + 1] = i;
                index++;
            }
        }

        // sort
        sortIntArray(merged);

        return merged;
    }

    public static int calculateAbsAverageElementValueInIntArray(int[] intArr) {
        int absAverage = 0;
        for (int value : intArr) {
            if (value < 0) {
                absAverage += (value * -1);
            } else {
                absAverage += value;
            }
        }
        return absAverage / intArr.length;
    }

    public static int[] removeElementFromIntArray(int i, int[] ints) {
        int[] newIntArr = new int[ints.length - 1];
        int index = 0;
        for (int anInt : ints) {
            try {
                if (anInt != i) {
                    newIntArr[index] = anInt;
                    index++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("There is no such number in the array");
            }
        }
        return newIntArr;
    }

    public static int[] generateRandomIntArrayWithSizeMinMax(int size, int min, int max) {
        int[] randomArr = new int[size];
        for (int i = 0; i < size; i++) {
            randomArr[i] = min + (int) (Math.random() * (max - min));
        }
        return randomArr;
    }

}
