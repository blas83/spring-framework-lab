package calculator;

public class Calculator {

    public int addIntegers(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Calculator().addIntegers(2, 3));
        }
    }
}
