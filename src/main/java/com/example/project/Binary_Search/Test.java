package com.example.project.Binary_Search;

public class Test {
    public static void main(String[] args) {
        int[] elements = {1, 3, 5, 7, 9, 11, 13};
        int target = 13;
        int expectedIndex = 6;
        int actualIndex = BinarySearch.binarySearch(elements, target);
    }
}
