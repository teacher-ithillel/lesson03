package ua.ithillel;

public class MainDemo {

    public static void main(String[] args) {

        int[] intArr = { 10, 20, 15, 22, 35, -100, 1, 250, 55, -52 };
        String[] strArr = { "hello", "world", "java", "python", "kotlin" };

        ArrayUtils.printIntArray(intArr);
//        [10, 20, 15, 22, 35, -100, 1, 250, 55, -52]

        ArrayUtils.printObjArray(strArr);
//        [hello, world, java, python, kotlin]

        int[] sortedInts = ArrayUtils.sortIntArray(intArr);
        ArrayUtils.printIntArray(sortedInts);
//        [-100, -52, 1, 10, 15, 20, 22, 35, 55, 250]

        int[] minAndMaxInts = ArrayUtils.findMinAndMaxFromIntArray(intArr);
        ArrayUtils.printIntArray(minAndMaxInts);
//        [-100, 250]

        String str = ArrayUtils.toOneStringInCamelCase(strArr);
        System.out.println(str);
//        helloWorldJavaPythonKotlin

        int sum = ArrayUtils.calculateSumElementsInIntArray(intArr);
        System.out.println(sum);
//        256

        int avg = ArrayUtils.calculateAbsAverageElementValueInIntArray(intArr); // берем абсолютные значения (без учета знака)
        System.out.println(avg);
//        56

        int[] mergedAndSortedInts = ArrayUtils.mergeAndSortTwoIntArray(new int[]{1, 3, 5}, new int[]{2, 4});
        ArrayUtils.printIntArray(mergedAndSortedInts);
//        [1, 2, 3, 4, 5]

        int[] updatedInts = ArrayUtils.removeElementFromIntArray(3, new int[]{1, 3, 5});
        ArrayUtils.printIntArray(updatedInts);
//        [1, 5]

        int[] generatedInts = ArrayUtils.generateRandomIntArrayWithSizeMinMax(5, 10, 100);
        ArrayUtils.printIntArray(generatedInts);
//        [11, 33, 45, 99, 70]
    }
}
