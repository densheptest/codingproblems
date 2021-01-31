package ztmalgoanddatastr.twosums;


import java.util.*;

/**
 * Find all pairs in array that sum to a number
 * <p>
 * <p>
 * <p>
 * I keep track of visited values and how many times they were found in map <num, num of times visited>
 * when finding a match, decrease num of times visited (available for future matches, by 1 by overwriting
 * if there was only one match before, remove value from map completely
 */
public class TwoSums {


    static int[] input1 = new int[]{1, 5, 2, 2, 6, 19, -92, 199, 3, 4, 5, 6, 0, 3, 1, 2};
    static int[] input2 = new int[]{1, 5, 6, 19, -92, 199, 3, 4, 5, 6, 9, -6, 9};
    static int[] input3 = new int[]{1, 1, 1, 2, 2, 2, 3, 4, 5, 6, 9, -6, 9};

    public static void main(String[] args) {
        findPairs(input3, 3);
    }

    static int[] findPairs(int[] input, int sum) {
        //loop and add visited values to a lookup map

        // when pair found, remove value from lookup, as they must to be reused

        //see what optimizations can be done

        List<Integer> results = new ArrayList<>();

        Map<Integer, Integer> checkedValues = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            int currentValue = input[i];
            int requiredValue = sum - currentValue;

            if (checkedValues.containsKey(requiredValue)) {

                System.out.println("Found pair: " + currentValue + " + " + requiredValue + " = " + sum);

                //updating output list
                results.add(currentValue);
                results.add(requiredValue);

                // decrementing or removing required value from checked hashMap
                if (checkedValues.get(requiredValue) > 1) {
                    checkedValues.put(requiredValue, checkedValues.get(requiredValue) - 1);
                } else {
                    checkedValues.remove(requiredValue);
                }
            } else {
                if (checkedValues.containsKey(currentValue)) {
                    checkedValues.put(currentValue, checkedValues.get(currentValue) + 1);
                } else {
                    checkedValues.put(currentValue, 1);
                }
            }
        }

        int[] resultArr = toIntArray(results);
        for (int i : resultArr) {
            System.out.println(i);
        }
        return resultArr;
    }

    static int[] toIntArray(List<Integer> list) {
        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++)
            ret[i] = list.get(i);
        return ret;
    }
}