package ua.ithillel;

public class ArrayUtils {

    public static void printObjArray(Object[] objArr) {
        StringBuilder arrBuilder = new StringBuilder();
        arrBuilder.append("[");
        for (int i = 0; i < objArr.length; i++) {
            arrBuilder.append(objArr[i]);
            if (i != objArr.length - 1) {
                arrBuilder.append(", ");
            }
        }
        arrBuilder.append("]");
        System.out.println(arrBuilder);
    }


    public static void printIntArray(int[] intArr) {
        StringBuilder intBuilder = new StringBuilder();
        intBuilder.append("[");
        for (int i = 0; i < intArr.length; i++) {
            intBuilder.append(intArr[i]);
            if (i != intArr.length - 1) {
                intBuilder.append(", ");
            }
        }
        intBuilder.append("]");
        System.out.println(intBuilder);
    }


    /**
     * method sorts an array with the selection sort algorithm
     */
    public static int[] sortIntArray(int[] intArr) {
        for (int i = 0; i < intArr.length; i++) {
            int min = i;
            for (int j = i + 1; j < intArr.length; j++) {
                if (intArr[j] < intArr[min]) {
                    min = j;
                }
            }
            int swap = intArr[i];
            intArr[i] = intArr[min];
            intArr[min] = swap;
        }
        return intArr;
    }


    public static int[] findMinAndMaxFromIntArray(int[] intArr) {
        int max = 0;
        int min = 0;
        for (int i1 : intArr) {
            if (i1 <= min) {
                min = i1;
            }
            if (i1 >= max) {
                max = i1;
            }
        }
        return new int[]{min, max};
    }


    public static String toOneStringInCamelCase(String[] strArr) {
        String camelCase = "";
        for (String word : strArr) {
            String as = word.toLowerCase();
            camelCase = camelCase.concat(as.substring(0, 1).toUpperCase()).concat(as.substring(1));
        }
        camelCase = camelCase.substring(0, 1).toLowerCase() + camelCase.substring(1);

        return camelCase;
    }


    public static int calculateSumElementsInIntArray(int[] intArr) {
        int sum = 0;
        for (int num : intArr) {
            sum += num;
        }
        return sum;
    }


    public static int[] mergeAndSortTwoIntArray(int[] ints1, int[] ints2) {
        int[] mergeTwoIntArr = new int[ints1.length + ints2.length];
        int index = 0;
        for (int i = 0; i < ints1.length; i++) {
            index = i;
            mergeTwoIntArr[i] = ints1[i];
        }
        if (index == ints1.length - 1) {
            for (int i : ints2) {
                mergeTwoIntArr[index + 1] = i;
                index++;
            }
        }
        return sortIntArray(mergeTwoIntArr);
    }


    public static int calculateAbsAverageElementValueInIntArray(int[] intArr) {
        int average = 0;
        for (int i1 : intArr) {
            if (i1 < 0) {
                average += (i1 * -1);
            } else {
                average += i1;
            }
        }
        return average / intArr.length;
    }


    public static int[] removeElementFromIntArray(int i, int[] ints) {
        int[] copy = new int[ints.length - 1];

        for (int j = 0, k = 0; j < ints.length; j++) {
            try {
                if (ints[j] != i) {
                    copy[k++] = ints[j];
                }
            } catch (NegativeArraySizeException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Incorrect method argument");
            }
        }

        return copy;
    }


    public static int[] generateRandomIntArrayWithSizeMinMax(int size, int min, int max) {
        int randomArr[] = new int[size];
        for (int i = 0; i < size; i++) randomArr[i] = (int) (min + Math.random() * (max - min) + 1);
        return randomArr;

    }

}

