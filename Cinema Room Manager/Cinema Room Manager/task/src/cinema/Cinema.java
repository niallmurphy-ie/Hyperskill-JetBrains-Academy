package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Bookings bookings = null;
        Seating seating = null;

        UserInterface userInterface = new UserInterface(scanner, bookings, seating);
        userInterface.start();

    }

}

class UserInterface {

    Scanner scanner;
    Bookings bookings;
    Seating seating;

    public UserInterface(Scanner scanner, Bookings bookings, Seating seating) {
        this.scanner = scanner;
        this.bookings = bookings;
        this.seating = seating;
    }

    void start() {

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsPerRow = scanner.nextInt();
        scanner.nextLine();

        // Create Seating and bookings
        this.bookings = new Bookings(rows, seatsPerRow);
        this.seating = new Seating(rows, seatsPerRow, bookings);

        while (true) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    seating.printSeating();
                    break;
                case "2":
                    makeBooking();
                    break;
                case "3":
                    statistics();
                    break;
                case "0":
                    return;
            }
        }
    }

    private void statistics() {
        double[] stats = seating.stats();
        System.out.printf("Number of purchased tickets: %d\n", (int) stats[0]);
        System.out.printf("Percentage: %.2f%%\n", stats[1]);
        System.out.printf("Current income: $%d\n", (int) stats[2]);
        System.out.printf("Total income: $%d\n", (int) stats[3]);
    }

    private void makeBooking() {
        // Get seat
        System.out.println("Enter a row number:");
        int seatX = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatY = scanner.nextInt();
        scanner.nextLine();
        // Check if seat is taken
        if (!seating.checkValidBooking(seatX, seatY)) {
            System.out.println("Wrong input!");
            return;
        }
        // Make the booking
        if (!bookings.addBooking(seatX, seatY)) {
            System.out.println("That ticket has already been purchased!");
            makeBooking();
        }
        ;
        System.out.println("Ticket price: $" + seating.seatPrice(seatX, seatY) + "\n");
    }
}
