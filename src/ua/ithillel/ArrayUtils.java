import java.util.Arrays;

public class ArrayUtils {

    static void printObjArray(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object o : objArr) {
            sb.append(o);
            if (!o.equals(objArr[objArr.length - 1])) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

    static void printIntArray(int[] intArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Integer o : intArr) {
            sb.append(o);
            if (!(o == intArr[intArr.length - 1])) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static int[] sortIntArray(int[] intArr) {
        return mergeSort(intArr, 0, intArr.length - 1);
    }


    /**
     * This method can search minimal and maximal integer value
     * from integer array
     */

    public static int[] findMinAndMaxFromIntArray(int[] intArr) {
        int maxValue = 0;
        int minValue = 0;

        for (int i : intArr) {
            if (i <= minValue) {
                minValue = i;
            }
            if (i >= maxValue) {
                maxValue = i;
            }
        }

        return new int[]{minValue, maxValue};
    }

    public static String toOneStringInCamelCase(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(strArr[0].substring(0, 1).toLowerCase()).append(strArr[0].substring(1));
        for (int i = 1; i < strArr.length; i++) {
            sb.append(strArr[i].substring(0, 1).toUpperCase()).append(strArr[i].substring(1));
        }
        return sb.toString();

    }

    public static int calculateSumElementsInIntArray(int[] intArr) {
        int sum = 0;
        for (int i : intArr) {
            sum += i;
        }
        return sum;
    }

    public static int[] mergeAndSortTwoIntArray(int[] ints1, int[] ints2) {
        int[] array1and2 = new int[ints1.length + ints2.length];
        System.arraycopy(ints1, 0, array1and2, 0, ints1.length);
        System.arraycopy(ints2, 0, array1and2, ints1.length, ints2.length);
        return sortIntArray(array1and2);
    }

    public static int calculateAbsAverageElementValueInIntArray(int[] intArr) {
        int average = 0;

        for (int i : intArr) {
            if (i < 0) {
                average += (i * -1);
            } else {
                average += i;
            }
        }
        return Math.abs(average / intArr.length);
    }

    public static int[] removeElementFromIntArray(int i, int[] ints) {
        int[] array = new int[ints.length - 1];

        for (int j = 0, k = 0; j < ints.length; j++) {
                if (ints[j] != i) {
                    array[k++] = ints[j];
                }
        }
        return array;
    }

    public static int[] generateRandomIntArrayWithSizeMinMax(int size, int min, int max) {
        int random[] = new int[size];
        for (int i = 0; i < size; i++) {
            random[i] = (int) (min + Math.random() * (max - min) + 1);
        }
        return random;
    }

    private static int[] mergeSort(int[] a, int lo, int hi) {

        if (hi <= lo)
            return null;
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid + 1, hi);

        int[] buf = Arrays.copyOf(a, a.length);

        System.arraycopy(a, lo, buf, lo, hi + 1 - lo);

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {

            if (i > mid) {
                a[k] = buf[j];
                j++;
            } else if (j > hi) {
                a[k] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                a[k] = buf[j];
                j++;
            } else {
                a[k] = buf[i];
                i++;
            }
        }
        return a;
    }
}
