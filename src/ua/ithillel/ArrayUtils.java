package ua.ithillel;

import java.util.Arrays;

public class ArrayUtils {

    public static void printObjArray(Object[] objArr) {
        //  System.out.println(Arrays.toString(objArr));
        System.out.print("[");
        for (int i = 0; i < objArr.length; i++) {
            if (i == objArr.length - 1) {
                System.out.print(objArr[i]);
                break;
            }
            System.out.print(objArr[i] + ", ");
        }
        System.out.println("]");
    }

    /**
     * Выводит в консоль все элементы массива
     */
    public static void printIntArray(int[] intArr) {
        //System.out.println(Arrays.toString(intArr));
        System.out.print("[");
        for (int i = 0; i < intArr.length; i++) {
            if (i == intArr.length - 1) {
                System.out.print(intArr[i]);
                break;
            }
            System.out.print(intArr[i] + ", ");
        }
        System.out.println("]");
    }
    //Сортировка вставками
    public static int[] sortIntArray(int[] intArr) {
//        Arrays.sort(intArr);
//        return intArr;
        int[] copyArray = copyOfArray(intArr);
        for (int left = 0; left < copyArray.length; left++) {
            int elm = copyArray[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (elm < copyArray[i]) {
                    copyArray[i + 1] = copyArray[i];
                } else {
                    break;
                }
            }
            copyArray[i + 1] = elm;
        }
        return copyArray;
    }

    public static int[] findMinAndMaxFromIntArray(int[] intArr) {
//        Arrays.sort(intArr);
//        return new int[]{intArr[0], intArr[intArr.length - 1]};

        int max = intArr[0];
        int min = intArr[0];
        for (int i : intArr) {
            if (i > max) max = i;
            else if (i < min) min = i;
        }
        return new int[]{min, max};
    }

    public static String toOneStringInCamelCase(String[] strArr) {
        StringBuilder result = new StringBuilder();
        String s;
        char[] arChar;
        for (int i = 0; i < strArr.length; i++) {
            //первое слово всегда начинается с маленькой буквы
            if (i == 0) {
                result.append(strArr[i].toLowerCase());
                continue;
            }
            s = strArr[i];
            char c = Character.toUpperCase(s.charAt(0));
            s = s.replace(s.charAt(0), c);
            result.append(s);
        }
        return result.toString();
    }

    public static int calculateSumElementsInIntArray(int[] intArr) {
        int sum = 0;
        for (int a : intArr) {
            sum += a;
        }
        return sum;
    }

    //Если в обоих массивах есть одинаковое число - мы оставляем оба числа
    public static int[] mergeAndSortTwoIntArray(int[] ints1, int[] ints2) {
        int[] newAr = new int[ints1.length + ints2.length];
        for (int i = 0; i < ints1.length; i++) {
            newAr[i] = ints1[i];
        }
        int j = 0;
        for (int i = ints1.length; i < newAr.length; i++) {
            newAr[i] = ints2[j++];
        }
        return sortIntArray(newAr);
    }

    public static int calculateAbsAverageElementValueInIntArray(int[] intArr) {
        int sum = 0;
        for (int a : intArr) {
            sum += Math.abs(a);
        }
        return sum / intArr.length;

    }

    //Удаляем все эл-ты i из массива
    public static int[] removeElementFromIntArray(int i, int[] ints) {
        int quantity = 0;
        for (int elm : ints) {
            if (elm == i) {
                quantity++;
            }
        }
        int h = 0;
        int[] newAr = new int[ints.length - quantity];
        for (int j = 0; j < ints.length; j++) {
            if (ints[j] == i) continue;
            newAr[h] = ints[j];
            h++;
        }
        return newAr;

    }

    //Считаем [min;max]
    public static int[] generateRandomIntArrayWithSizeMinMax(int size, int min, int max) {
        int[] ar = new int[size];
        for (int i = 0; i < size; i++) {
            ar[i] = (int) (Math.random() * ((max - min) + 1));
        }
        return ar;
    }

    private static int[] copyOfArray(int[] ar) {
        int[] copyArray = new int[ar.length];
        for (int i = 0; i < ar.length; i++) {
            copyArray[i] = ar[i];
        }
        return copyArray;
    }
}
