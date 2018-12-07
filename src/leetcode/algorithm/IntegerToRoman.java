package leetcode.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IntegerToRoman {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(integerToRoman(Integer.parseInt(line)));
        }
    }

    private static String integerToRoman(int input) {
        int q = (input / Roman.M.value);
        int b = ((input - q * Roman.M.value) / Roman.C.value);
        int s = ((input - q * Roman.M.value - b * Roman.C.value) / Roman.X.value);
        int g = input - q * Roman.M.value - b * Roman.C.value - s * Roman.X.value;

        StringBuilder sb = new StringBuilder();

        if (q > 0) {
            for (int i = 0; i < q; i++) {
                sb.append(Roman.M.name());
            }
        }

        if (b > 0) {
            sb.append(numberToRoman(b, Roman.C, Roman.D, Roman.M));
        }

        if (s > 0) {
            sb.append(numberToRoman(s, Roman.X, Roman.L, Roman.C));
        }

        if (g > 0) {
            sb.append(numberToRoman(g, Roman.I, Roman.V, Roman.X));
        }
        return sb.toString();
    }

    private static String numberToRoman(int number, Roman base, Roman middle, Roman nbase) {
        StringBuilder sb = new StringBuilder();
        switch (number) {
            case 0:
                break;
            case 1:
                sb.append(base.name());
                break;
            case 2:
                sb.append(base.name()).append(base.name());
                break;
            case 3:
                sb.append(base.name()).append(base.name()).append(base.name());
                break;
            case 4:
                sb.append(base.name()).append(middle.name());
                break;
            case 5:
                sb.append(middle.name());
                break;
            case 6:
                sb.append(middle.name()).append(base.name());
                break;
            case 7:
                sb.append(middle.name()).append(base.name()).append(base.name());
                break;
            case 8:
                sb.append(middle.name()).append(base.name()).append(base.name()).append(base.name());
                break;
            case 9:
                sb.append(base.name()).append(nbase.name());
                break;
        }
        return sb.toString();
    }
}
