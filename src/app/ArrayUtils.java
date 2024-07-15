package app;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtils {

    public static void mergeSort(int[] array) {
        if (array.length < 2) return;

        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new Random().ints(10, 1, 100).toArray();
        System.out.println("Original array: " + Arrays.toString(array));

        mergeSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));

        int target = array[new Random().nextInt(array.length)];
        int result = binarySearch(array, target);
        System.out.println("Searching for " + target + ": " + (result != -1 ? "Found at index " + result : "Not found"));
    }
}