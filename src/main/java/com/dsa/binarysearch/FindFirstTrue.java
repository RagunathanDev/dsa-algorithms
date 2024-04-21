package com.dsa.binarysearch;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * Program : find the first true in the given list/array
 * Input : false false false true true true
 *
 * NOTE:  findFirstTrue index
 * */
public class FindFirstTrue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Boolean> listOfValue = convertToBoolean(scanner.nextLine()).stream()
                .map(item -> item.equals("true"))
                .collect(Collectors.toList());
        int index = binarySearch(listOfValue);
        System.out.println("first True find in the index of: " + index);
    }

    private static int binarySearch(List<Boolean> listOfValue) {
        int left = 0;
        int right = listOfValue.size() - 1;
        int findFirstTrue = -1;
        int mid;

        while (left <= right) {
            mid = left + ((right - left) / 2);
            if (Boolean.TRUE.equals(listOfValue.get(mid))) {
                findFirstTrue = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return findFirstTrue;
    }

    private static List<String> convertToBoolean(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

}
