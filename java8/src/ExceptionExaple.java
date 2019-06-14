import java.util.function.BiConsumer;

public class ExceptionExaple {

    public static void main(String[] args) {

        int[] numbers = new int[] {1,2,3,4};
        int key = 2;
        process(numbers, key, (v, k) -> System.out.println(v + k));

        String[] sentence = new String[] {"Miral", "Patel", "weds", "Shreya", "Amin"};
        proc(sentence, " ", (w, u) -> System.out.print(w + u));
    }

    private static void process(int[] numbers, int key, BiConsumer<Integer, Integer> consumer) {
        for (int i : numbers) {
            consumer.accept(i, key);
        }
    }

    private static <T, U> void proc(T[] elements, U u, BiConsumer<T, U> consumer) {
        for (T t : elements) {
            consumer.accept(t, u);
        }
    }
}
