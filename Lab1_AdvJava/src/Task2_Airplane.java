import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Task2_Airplane {
    private String flightNumber;
    private String destination;
    private LocalTime scheduledDeparture;
    private int delayMinutes; // total accumulated delay

    // format to display time as HH:mm
    private static final DateTimeFormatter TIME_FMT = DateTimeFormatter.ofPattern("HH:mm");

    // constructor
    public Task2_Airplane(String flightNumber, String destination, LocalTime scheduledDeparture) {
        this.flightNumber = Objects.requireNonNull(flightNumber,"flightNumber");
        this.destination = Objects.requireNonNull(destination, "destination");
        this.scheduledDeparture = Objects.requireNonNull(scheduledDeparture);
        this.delayMinutes = 0; // start with no delay
    }

    // Getters
    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public LocalTime getScheduledDeparture() {
        return scheduledDeparture;
    }

    public int getDelayMinutes() {
        return delayMinutes;
    }

    // Setters
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = Objects.requireNonNull(flightNumber,"flightNumber");
    }

    public void setDestination(String destination) {
        this.destination = Objects.requireNonNull(destination, "destination");
    }

    public void setScheduledDeparture(LocalTime scheduledDeparture) {
        this.scheduledDeparture = Objects.requireNonNull(scheduledDeparture);
    }

    // delay the flight by some minutes and update departure time
    public void delay(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Delay minutes cannot be negative.");
        }
        this.delayMinutes += minutes;
        this.scheduledDeparture = this.scheduledDeparture.plusMinutes(minutes);
        System.out.println("Flight " + flightNumber + " delayed by " + minutes +
                " minutes. New departure time: " + scheduledDeparture.format(TIME_FMT));
    }

    // check current status of the flight
    public void checkStatus() {
        if (delayMinutes == 0) {
            // no delay
            System.out.println("Flight " + flightNumber + " to " + destination +
                    " is on time. Scheduled departure: " + scheduledDeparture.format(TIME_FMT));
        } else {
            // delayed
            System.out.println("Flight " + flightNumber + " to " + destination +
                    " is delayed by " + delayMinutes + " minutes. New departure time: " +
                    scheduledDeparture.format(TIME_FMT));
        }
    }

    @Override
    public String toString() {
        return String.format("Airplane{flightNumber='%s', destination='%s', scheduledDeparture='%s', delayMinutes=%d}",
            flightNumber, destination, scheduledDeparture.format(TIME_FMT), delayMinutes);
    }
}
