public class HandfulOfMethods {
    public HandfulOfMethods() {
    }

    @RepeatCount(3)
    public void publicMethod1(String param1, int param2) {
        System.out.println("Вызван публичный метод 1");
    }

    @RepeatCount(2)
    protected void protectedMethod1() {
        System.out.println("Вызван защищенный метод 1");
    }

    @RepeatCount(1)
    protected void protectedMethod2(String param) {
        System.out.println("Вызван защищенный метод 2 с параметром: " + param);
    }

    private void privateMethod1() {
        System.out.println("Вызван приватный метод 1");
    }

    private void privateMethod2(int param) {
        System.out.println("Вызван приватный метод 2 с параметром: " + param);
    }

    @RepeatCount(2)
    private void privateMethod3(double param1, boolean param2) {
        System.out.println("Вызван приватный метод 3 с параметрами: " + param1 + ", " + param2);
    }
}
