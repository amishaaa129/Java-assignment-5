import java.util.Optional;
import java.util.NoSuchElementException;

public class OptionalEmail {

    public static void main(String[] args) {

        Optional<String> email =
                Optional.of("student@example.com");


        Optional<String> emptyEmail = Optional.empty();

        email.ifPresent(e -> System.out.println("Email: " + e));

        String result = emptyEmail.orElse("default@example.com");
        System.out.println("Default email: " + result);

        try {
            String e = emptyEmail.orElseThrow(
                () -> new NoSuchElementException("Email not found")
            );

            System.out.println(e);
        } catch (NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
