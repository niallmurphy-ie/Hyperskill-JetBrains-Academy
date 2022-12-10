package cinema;

import java.sql.Array;
import java.util.Scanner;

public class Seating {

    private int currentIncome;
    private int rows;
    private int seatsPerRow;
    Bookings bookings;

    public Seating(int x, int y, Bookings bookings) {
        this.rows = x;
        this.seatsPerRow = y;
        this.bookings = bookings;
    }

    // Stats
    double[] stats() {
        double[] stats = new double[4];
        stats[0] = bookings.getTotalBookings();
        stats[1] = (stats[0] / (rows * seatsPerRow)) * 100;
        stats[2] = this.currentIncome;
        stats[3] = maxIncome();
        return stats;
    }

    int seatPrice(int seatX, int seatY) {
        if (this.rows * this.seatsPerRow <= 60) {
            return 10;
        }
        int income = seatX <= rows / 2 ? 10 : 8;
        this.currentIncome += income;
        return income;
    }

    Boolean checkValidBooking(int seatX, int seatY) {
        // User seating is from 1.
        seatX--;
        seatY--;
        if (seatX < 0 || seatX > this.rows - 1) {
            return false;
        }
        if (seatY < 0 || seatY > this.seatsPerRow - 1) {
            return false;
        }
        return true;
    }

    int maxIncome() {
        if (rows * seatsPerRow <= 60) {
            return rows * seatsPerRow * 10;
        }
        int frontRows = rows / 2;
        int backRows = rows - frontRows;
        return (frontRows * seatsPerRow * 10) + (backRows * seatsPerRow * 8);
    }

    void printSeating() {
        // Current Bookings
        int[][] currentBookings = bookings.getBookings();
        // Top line
        System.out.println("Cinema:");
        // Column headers
        String header = " ";
        for (int i = 1; i <= seatsPerRow; i++) {
            header = header + " " + i;
        }
        System.out.println(header);
        // Rows
        int i = 0;
        while (i < rows) {
            String line;
            line = (i + 1) + "";
            for (int j = 0; j < seatsPerRow; j++) {
                line = (currentBookings[i][j] == 1) ? line + " B" : line + " S";
            }
            System.out.println(line);
            i++;
        }
        System.out.println("");
    }
}
