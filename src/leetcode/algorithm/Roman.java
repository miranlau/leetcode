package leetcode.algorithm;

public enum Roman {
    I(1), V(5), X(10), L(50), C(100), D(500), M(1000);

    int value;

    Roman(int value) {
        this.value = value;
    }

    public static Roman valueOf(Character ch) {
        return Roman.valueOf(ch.toString());
    }
}
