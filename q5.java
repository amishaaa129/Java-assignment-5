import java.util.Optional;
import java.util.Objects;

class GenericUtility {
    public static <T> boolean isEqual(T a, T b) {
        return Objects.equals(a, b);
    }

    public static <T> T getDefault(
            Optional<T> value, T defaultValue) {
        Objects.requireNonNull(value, "Optional cannot be null");
        return value.orElse(defaultValue);
    }

    public static <T extends Comparable<? super T>> T max(T a, T b) {
        Objects.requireNonNull(a, "First value cannot be null");
        Objects.requireNonNull(b, "Second value cannot be null");

        return a.compareTo(b) >= 0 ? a : b;
    }

    public static boolean isNull(Object obj) {
        return Objects.isNull(obj);
    }
}

public class GenericUtilityDemo {

    public static void main(String[] args) {

        System.out.println(
                GenericUtility.isEqual("Java", "Java"));
        System.out.println(
                GenericUtility.isEqual(10, 20));

        Optional<String> name = Optional.of("Rahul");
        Optional<String> empty = Optional.empty();

        System.out.println(
                GenericUtility.getDefault(name, "Guest"));
        System.out.println(
                GenericUtility.getDefault(empty, "Guest"));

        System.out.println(
                GenericUtility.max(10, 25));
        System.out.println(
                GenericUtility.max("Apple", "Banana"));

        String str = null;
        Integer num = 100;

        System.out.println(GenericUtility.isNull(str));
        System.out.println(GenericUtility.isNull(num));
    }
}
