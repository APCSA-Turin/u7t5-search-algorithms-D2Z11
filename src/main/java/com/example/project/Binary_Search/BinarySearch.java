package com.example.project.Binary_Search;

public class BinarySearch {
    // implements binary search on the elements list for target,
    // and returns the index at which the target is found, or -1 if
    public static int binarySearch(int[] elements, int target) {
        int loopCounter = 0; // for testing
        int leftIdx = 0;   // TODO: assign this initial value
        int rightIdx = elements.length - 1;  // TODO: assign this initial value
        if (elements.length == 0) {
            return -1;
        }
        if (elements[0] == target) {
            return 0;
        }

        while (leftIdx < rightIdx) {  // TODO: determine this condition (hint: see slides 61-63)
            loopCounter++; // for testing
            int middleIdx = (rightIdx+leftIdx) / 2;  // TODO: determine what this should be
            System.out.print(elements[middleIdx] + "\n"); // for testing

            // TODO: write the rest of the code to compare middleIdx to the target
            //  and adjust leftIdx and rightIdx as appropriate (see slides if needed)
            if (elements[middleIdx] == target) {
                return middleIdx;
            } else if (elements[middleIdx] > target) {
                rightIdx = middleIdx - 1;
            } else {
                leftIdx = middleIdx + 1;
            }
            System.out.println(leftIdx + " " + rightIdx + " " + middleIdx);
        }
        if (leftIdx == rightIdx) {
            if (elements[leftIdx] == target) {
                return leftIdx;
            }
        }
        return -1; // not found
    }
}
