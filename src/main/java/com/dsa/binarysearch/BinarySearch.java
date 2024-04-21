package com.dsa.binarysearch;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
Program : Vanilla binary search.
Input : 2 10 43 55 78 89 94

 */
public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listOfValue = convertToList(scanner.nextLine())
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int target = scanner.nextInt();
        int index = searchTarget(listOfValue, target);
        System.out.println("Target element index was : " + index);
    }

    private static int searchTarget(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) / 2);
            if (arr.get(mid) == target) return mid;
            if (arr.get(mid) < target)
                left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    private static List<String> convertToList(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }
}
