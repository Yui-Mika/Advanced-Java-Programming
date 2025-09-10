// Task2 - example main program: AirplaneTest.java
import java.time.LocalTime;

public class Task2_AirplaneTest {
    public static void main(String[] args) {
        Task2_Airplane flight1 = new Task2_Airplane("VN123", "Hanoi", LocalTime.of(10, 30));
        Task2_Airplane flight2 = new Task2_Airplane("VN456", "Da Nang", LocalTime.of(12, 45));

        System.out.println("=== Initial Flight Status ===");
        flight1.checkStatus();
        flight2.checkStatus();

        System.out.println("\n=== Applying Delay to flight1 ===");
        flight1.delay(20);
        flight1.checkStatus();

        System.out.println("\n=== Updated Departure Times ===");
        System.out.println("Flight " + flight1.getFlightNumber() + " new departure: " + flight1.getScheduledDeparture());
        System.out.println("Flight " + flight2.getFlightNumber() + " departure: " + flight2.getScheduledDeparture());

        System.out.println("\n=== Updating Flight 2 Details ===");
        flight2.setDestination("Hue");
        flight2.delay(15);
        System.out.println("Flight " + flight2.getFlightNumber() + " new destination: " + flight2.getDestination());
        flight2.checkStatus();
    }
}
