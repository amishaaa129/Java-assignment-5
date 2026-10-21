import java.util.Optional;
import java.util.Objects;

class Result<T extends Number> {

    private T marks;
    private double maximumMarks;
    private double passingPercentage;

    Result(T marks, double maximumMarks, double passingPercentage) {
        this.marks = Objects.requireNonNull(
                marks, "Marks cannot be null");

        if (maximumMarks <= 0) {
            throw new IllegalArgumentException(
                    "Maximum marks must be positive");
        }

        if (passingPercentage < 0 || passingPercentage > 100) {
            throw new IllegalArgumentException(
                    "Passing percentage must be between 0 and 100");
        }

        this.maximumMarks = maximumMarks;
        this.passingPercentage = passingPercentage;
    }

    double getPercentage() {
        return (marks.doubleValue() / maximumMarks) * 100;
    }

    boolean hasPassed() {
        return getPercentage() >= passingPercentage;
    }

    Optional<T> getMarks() {
        return Optional.ofNullable(marks);
    }

    void displayResult() {
        getMarks().ifPresent(m -> {
            System.out.println("Marks: " + m);
            System.out.println("Percentage: " + getPercentage() + "%");
            System.out.println("Result: " +
                    (hasPassed() ? "PASS" : "FAIL"));
        });
    }
}

public class StudentResult {
    public static void main(String[] args) {

        Result<Integer> r1 = new Result<>(85, 100, 40);
        Result<Double> r2 = new Result<>(32.5, 50, 40);
        Result<Float> r3 = new Result<>(15.0f, 50, 40);

        System.out.println("Student 1:");
        r1.displayResult();

        System.out.println("\nStudent 2:");
        r2.displayResult();

        System.out.println("\nStudent 3:");
        r3.displayResult();
    }
}
