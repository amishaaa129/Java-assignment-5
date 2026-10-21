import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Objects;

public class EventManager {

    public static void main(String[] args) {

        String eventName = Objects.requireNonNull("Java Workshop", "Event name cannot be null");

        LocalDate eventDate = LocalDate.of(2026, 12, 15);
        LocalTime startTime = LocalTime.of(10, 30);

        Optional<String> venue = Optional.of("College Auditorium");

        System.out.println("Event: " + eventName);
        System.out.println("Date: " + eventDate);
        System.out.println("Start time: " + startTime);

        LocalDate today = LocalDate.now();

        if (eventDate.isAfter(today)) {
            System.out.println("Event is in the future.");
        } else if (eventDate.isBefore(today)) {
            System.out.println("Event is in the past.");
        } else {
            System.out.println("Event is today.");
        }

        long daysRemaining =
                ChronoUnit.DAYS.between(today, eventDate);

        System.out.println("Days remaining: " + daysRemaining);

        LocalTime endTime = startTime.plusHours(2);
        System.out.println("End time: " + endTime);

        System.out.println("Venue: " +
                venue.orElse("Venue not specified"));
    }
}
