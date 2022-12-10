package cinema;


public class Bookings {

    private int totalBookings;
    private int[][] bookings;

    public Bookings(int rows, int seatsPerRow) {
        this.totalBookings = 0;
        this.bookings = new int[rows][seatsPerRow];
    }

    Boolean addBooking(int seatX, int seatY) {
        // Map user input to 0-start array
        if (this.bookings[seatX - 1][seatY - 1] != 1) {
            this.bookings[seatX - 1][seatY - 1] = 1;
            this.totalBookings++;
            return true;
        }
        return false;
    }

    int[][] getBookings() {
        return this.bookings;
    }

    int getTotalBookings() {
        return totalBookings;
    }

}

