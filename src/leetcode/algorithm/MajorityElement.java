package leetcode.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            System.out.println(majorityElement(nums));
        }
    }

    private static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    private static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;

        Integer sameNum = null;
        int sameTimes = 0;
        for (int i = 0; i < size; i++) {
            int num = nums[i];

            if(sameNum == null) {
                sameNum = num;
                sameTimes = 1;
            } else {
                if (num == sameNum) {
                    sameTimes++;
                    if (sameTimes > size / 2) {
                        return sameNum;
                    }
                } else {
                    sameNum = num;
                    sameTimes = 1;
                }
            }
        }

        return 0;
    }
}
