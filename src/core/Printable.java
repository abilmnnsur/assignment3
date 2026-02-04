package core;

public interface Printable {
    String print();
    default void printToConsole() {
        System.out.println(print());
    }
    static void printSeparator() {
        System.out.println("================================");
    }
}
