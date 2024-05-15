package horse;

public class RandomNumber {
    public static int between(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1) + min);
    }
}
