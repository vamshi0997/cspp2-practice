import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * show class.
 */
class Show {

    /**
     * movie name.
     */
    private String moviename;

    /**
     * mtime of show.
     */
    private String time;

    /**
     * seat numbers.
     */
    private String[] seats;

    /**
     * Constructs the object.
     *
     * @param seats1 string.
     * @param time1 string.
     * @param moviename1 string.
     */
    Show(final String moviename1, final String time1,
         final String[] seats1) {
        this.moviename = moviename1;
        this.time = time1;
        this.seats = seats1;
    }

    /**
     * @return moviename.
     */
    String getMovieName() {
        return this.moviename;
    }

    /**
     * @param movie string.
     */
    void setMovieName(final String movie) {
        this.moviename = movie;
    }

    /**
     * @return time.
     */
    String getTime() {
        return this.time;
    }

    /**
     * @param time2 string.
     */
    void setTime(final String time2) {
        this.time = time2;
    }

    /**
     * @param tickets String
     * @return true
     */
    public boolean hasTickets(final String[] tickets) {
        int count = 0;
        for (String i : tickets) {
            for (String j : seats) {
                if (i.equals(j)) {
                    count++;
                    break;
                }
            }
        }

        return count != 0;
    }

    /**
     * @param booked string.
     */
    public void book(final String[] booked) {
        for (String b : booked) {
            for (int i = 0; i < seats.length; i++) {
                if (b.equals(seats[i])) {
                    seats[i] = "N/A";
                    break;
                }
            }
        }
    }

    /**
     * @return name, time
     */
    public String toString() {
        return moviename + "," + time;
    }

    /**
     * @return name, time, seats.
     */
    public String represent() {
        return moviename + "," + time + ","
               + Arrays.toString(seats).replace(" ", "");
    }

}

/**
 * BookYourShow.
 */
class BookYourShow {

    /**
     * to store the talkies info.
     */
    private ArrayList<Show> shows = new ArrayList<Show>();

    /**
     * to store the bookings details.
     */
    private ArrayList<Patron> bookers = new ArrayList<Patron>();

    /**
     * Adds a show.
     *
     * @param movie movie
     * @param time string.
     * @param seatnum string.
     */
    public void addAShow(final String movie, final String time,
                         final String[] seatnum) {
        Show show1 = new Show(movie, time, seatnum);
        shows.add(show1);
    }

    /**
     * Gets a show.
     *
     * @param moviename string.
     * @param mtime string.
     *
     * @return show
     */
    public String getAShow(final String moviename, final String mtime) {
        for (Show s : shows) {
            if (s.getMovieName().equals(moviename)
                    && s.getTime().equals(mtime)) {
                return s.toString();
            }
        }

        return "No show";
    }

    /**
     * book the show.
     *
     * @param name string.
     * @param moviename string
     * @param number string
     * @param mtime string
     * @param seats string.
     */
    public void bookAShow(final String name, final String moviename,
                          final String number, final String mtime,
                          final String[] seats) {
        boolean flag = false;
        boolean dateflag = false;
        Show selected = null;
        int count = 0;


        for (Show s : shows) {
            if (s.getMovieName().equals(moviename)
                    && s.hasTickets(seats)
                    && s.getTime().equals(mtime)) {
                selected = s;
                flag = true;
                dateflag = false;
                break;
            } else if (!s.getMovieName().equals(moviename)) {
                count++;
            } else if (!s.getTime().equals(mtime)) {
                dateflag = true;
            }
        }

        if (flag) {
            Patron booker = new Patron(name, number);
            bookers.add(booker);
            booker.setBookingtime(mtime);
            booker.setMoviename(moviename);
            selected.book(seats);
        }

        if (count == shows.size() || dateflag) {
            System.out.println("No show");
        }


    }

    /**
     * ticket info.
     *
     * @param moviename string.
     * @param mtime string.
     * @param  mobilenum string. 
     *
     * @return represents ticket.
     */
    public String printTicket(final String moviename,
                              final String mtime, final String mobilenum) {
        for (Patron p : bookers) {
            if (p.getMoviename().equals(moviename)
                    && p.getBookingtime().equals(mtime)
                    && p.getNumber().equals(mobilenum)) {
                return p.toString();
            }
        }
        return "Invalid";
    }

    /**
     * Shows all info about shows.
     */
    public void showAll() {
        for (Show s : shows) {
            System.out.println(s.represent());
        }
    }

}


/**
 * patron class.
 */
class Patron {
	/**
	 * person name.
	 */
	private String name;
	/**
	 * person number.
	 */
	private String number;
	/**
     * time.
     */
    private String bookingtime;

    /**
     * moviename.
     */
    private String moviename;
	/**
	 * constructor.
	 * @param name1 String
	 * @param number1 String
	 */
	Patron(final String name1, final String number1) {
		this.name = name1;
		this.number = number1;
	}
	/**
	 * @return name.
	 */
	String getName() {
		return this.name;
	}
	/**
	 * @param name2 String.
	 */
	void setName(final String name2) {
        this.name = name2;
	}
	/**
	 * @return number.
	 */
	public String getNumber() {
        return this.number;
	}
	/**
	 * @param number2 string.
	 */
	void setNumber(final String number2) {
		this.number = number2;
	}
	/**
     * @return String.
     */
    public String toString() {
        return number + " " + name + " " + bookingtime;
    }
	/**
     * Gets the bookingtime.
     *
     * @return bookingtime.
     */
    String getBookingtime() {
        return this.bookingtime;
    }

    /**
     * Sets the bookingtime.
     *
     * @param bookingtime1 string.
     */
    void setBookingtime(final String bookingtime1) {
        this.bookingtime = bookingtime1;
    }

//moviename

    /**
     * Gets the moviename.
     *
     * @return moviename.
     */
    String getMoviename() {
        return this.moviename;
    }

    /**
     * Sets the moviename.
     *
     * @param moviename1 string.
     */
    void setMoviename(final String moviename1) {
        this.moviename = moviename1;
    }
}



/**
 * Solution class.
 */
public final class Solution {
    /**
     * default constructor.
     */
    private Solution() {

    }
    /**
     * @param args string[].
     */
    public static void main(final String[] args) {
        BookYourShow bys = new BookYourShow();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().
                              replace("[", "").replace("]", "").split(",");
            String[] check = tokens[0].split(" ");
            switch (check[0]) {
            case "add":
                int k = 2;
                String[] seats = new String[tokens.length - 2];
                for (int j = 0; j < seats.length; j++) {
                    seats[j] = tokens[k++];
                }
                bys.addAShow(check[1], tokens[1], seats);
                break;

            case "book":
                k = 2 + 2;
                seats = new String[tokens.length - 2 - 2];
                for (int j = 0; j < seats.length; j++) {
                    seats[j] = tokens[k++];
                }
                //final int tmp = 3;
                bys.bookAShow(tokens[2], check[1],
                              tokens[3], tokens[1], seats);
                break;
            case "get":
                System.out.println(bys.getAShow(check[1], tokens[1]));
                break;
            case "print":
                System.out.println(bys.printTicket(check[1],
                                                   tokens[1], tokens[2]));
                break;
            case "showAll":
                bys.showAll();
                break;
            default:
                break;

            }
        }
    }
}
