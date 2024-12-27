package sequential;

public class SequentialApplication {

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        for (int i = 0; i < 10; i++) {
            System.out.println("[TEST 1] : " + i);
        }
    }

    private static void test2() {
        for (int i = 0; i < 10; i++) {
            System.out.println("[TEST 2] : " + i);
        }
    }
}
