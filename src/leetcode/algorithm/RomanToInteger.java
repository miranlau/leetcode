package leetcode.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RomanToInteger {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Solution2 solution = new Solution2();
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(solution.romanToInt(line));
        }
    }
}

class Solution2 {
    public int romanToInt(String s) {
        int result = 0;

        int len = s.length();
        for (int i = 0; i < len; i++) {
            char char1 = s.charAt(i);
            Roman roman1 = Roman.valueOf(char1);

            Roman roman2 = null;
            if (i + 1 < len) {
                roman2 = Roman.valueOf(s.charAt(i + 1));
            }

            Roman roman3 = null;
            if (i + 2 < len) {
                roman3 = Roman.valueOf(s.charAt(i + 2));
            }

            int temp = 0;
            switch (roman1) {
                case I:
                    temp = Roman.I.value;
                    if (Roman.I.equals(roman2)) {
                        temp += Roman.I.value;
                        i++;

                        if (Roman.I.equals(roman3)) {
                            temp += Roman.I.value;
                            i++;
                        }
                    } else if (Roman.V.equals(roman2)) {
                        temp = Roman.V.value - temp;
                        i++;
                        break;
                    } else if (Roman.X.equals(roman2)) {
                        temp = Roman.X.value - temp;
                        i++;
                        break;
                    }

                    break;
                case V:
                    temp = Roman.V.value;
                    break;
                case X:
                    temp = Roman.X.value;
                    if (Roman.X.equals(roman2)) {
                        temp += Roman.X.value;
                        i++;
                        if (Roman.X.equals(roman3)) {
                            temp += Roman.X.value;
                            i++;
                        }
                    } else if (Roman.L.equals(roman2)) {
                        temp = Roman.L.value - temp;
                        i++;
                        break;
                    } else if (Roman.C.equals(roman2)) {
                        temp = Roman.C.value - temp;
                        i++;
                        break;
                    }
                    break;
                case L:
                    temp = Roman.L.value;
                    break;
                case C:
                    temp = Roman.C.value;
                    if (Roman.C.equals(roman2)) {
                        temp += Roman.C.value;
                        i++;

                        if (Roman.C.equals(roman3)) {
                            temp += Roman.C.value;
                            i++;
                        }
                    } else if (Roman.D.equals(roman2)) {
                        temp = Roman.D.value - temp;
                        i++;
                        break;
                    } else if (Roman.M.equals(roman2)) {
                        temp = Roman.M.value - temp;
                        i++;
                        break;
                    }

                    break;
                case D:
                    temp = Roman.D.value;
                    break;
                case M:
                    temp = Roman.M.value;
                    if (Roman.M.equals(roman2)) {
                        temp += Roman.M.value;
                        i++;
                        if (Roman.M.equals(roman3)) {
                            temp += Roman.M.value;
                            i++;
                        }
                    }

                    break;
            }

            result += temp;
        }

        return result;
    }
}
