public class Main {
    public static void main(String[] args) {
        Fighter f1 = new Fighter("A", 10, 100, 85, 30, 50);
        Fighter f2 = new Fighter("B", 20, 85, 95, 40, 50);

        Ring ring = new Ring(f1, f2, 80, 100);
        ring.run();
    }
}
