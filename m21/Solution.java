import java.util.Scanner;
import java.util.ArrayList;
/**
 * log class for all methods.
 */
class Log {
	/**
	 * foodlog arraylist.
	 */
	private ArrayList<Foodlog> flog = new ArrayList<Foodlog>();
	/**
	 * sleeplog arraylist.
	 */
	private ArrayList<Waterlog> walog = new ArrayList<Waterlog>();
	/**
	 * Activitylog arraylist.
	 */
	private ArrayList<Activity> alog = new ArrayList<Activity>();
	/**
	 * weightlog arraylist.
	 */
	private ArrayList<Weight> wlog = new ArrayList<Weight>();
	/**
	 * sleeplog arraylist.
	 */
	private ArrayList<Sleep> slog = new ArrayList<Sleep>();
	/**
	 * addfood method.
	 * 
	 * @param item foodlog.
	 */
    public void addToFood(Foodlog item) {
       flog.add(item);
    }
    /**
	 * addwater method.
	 * 
	 * @param item waterlog.
	 */
    public void addToWater(Waterlog item) {
    	walog.add(item);
    }
    /**
	 * addactivity method.
	 * 
	 * @param item activitylog.
	 */
    public void addToActivity(Activity item) {
    	alog.add(item);
    }
    /**
	 * addweight method.
	 * 
	 * @param item waterlog.
	 */
    public void addToWeight(Weight item) {
    	wlog.add(item);
    }
    /**
	 * addsleep method.
	 * 
	 * @param item sleeplog.
	 */
    public void addToSleep(Sleep item) {
    	slog.add(item);
    }
    public void foodl() {
        for (Foodlog i: flog) {
            System.out.println(i.fshow());
    	}	
    }
    public void waterl() {
    	for (Waterlog j: walog) {
    		System.out.println(j.wshow());
    	}
    }
    public void physical() {
        for (Activity k: alog) {
    		System.out.println(k.ashow());
    	}	
    }
    public void weight() {
    	for (Weight l: wlog) {
    		System.out.println(l.weshow());
    	}
    }
    public void sleep() {
    	for (Sleep m: slog) {
    		System.out.println(m.sshow());
    	}
    }
    /**
     * summary gives all the log details sequentially.
     */
    public void summary() {
    	for (Foodlog i: flog) {
            System.out.println(i.fshow());
    	}
    	for (Waterlog j: walog) {
    		System.out.println(j.wshow());
    	}
    	for (Activity k: alog) {
    		System.out.println(k.ashow());
    	}
    	for (Weight l: wlog) {
    		System.out.println(l.weshow());
    	}
    	for (Sleep m: slog) {
    		System.out.println(m.sshow());
    	}
    }

}

/**
 * class foodlog.
 */
class Foodlog {
	/**
	 * food item.
	 */
	private String fooditem;
	/**
	 * food quantity.
	 */
    private int quantity;
    /**
     * time.
     */
    private String time;
    /**
     * given date.
     */
    private String date;
    /**
     * constructor for fooditem, quantity, time
     * 
     * @param fooditem1 fooditems.
     * @param quantity1 quantity
     * @param time1 time.
     */
    Foodlog(final String fooditem1, final int quantity1, final String date1,final String time1) {
    	this.fooditem = fooditem1;
    	this.quantity = quantity1;
    	this.time = time1;
    	this.date = date1;
    }
    /**
     * to get food item.
     *
     * @return fooditem.
     */
    String getFoodItem() {
    	return this.fooditem;
    }
    /**
     * setting food item.
     * 
     * @param fooditem2 String
     */
    void setFoodItem(final String fooditem2) {
    	this.fooditem = fooditem2;
    }
    /**
     * getting the quantity.
     *
     * @return quantity.
     */
    int getQuantity() {
    	return this.quantity;
    }
    /**
     * setting quantity.
     * 
     * @param quantity int
     */
    void setQuantity(final int quantity2) {
    	this.quantity = quantity2;
    }
    /**
     * getting time.
     *
     * @return time
     */
    String time() {
    	return this.time;
    }
    /**
     * setting time.
     * 
     * @param time2 String
     */
    void setTime(final String time2) {
    	this.time = time2;
    }
    public String fshow() {
    	System.out.println("Food");
    	return "Date:" + date + "\n" + "Time:" + time + "\n" + "Name:" + fooditem + "\n" + "Quantity:" + quantity;
    }
}

/**
 * class waterlog.
 */
class Waterlog {
	/**
	 * quantity of water.
	 */
    private String waterQuantity;
    private String date;
    private String time;
    /**
     * constructor for water log.
     *
     * @param waterQuantity1 quantity.
     */
    Waterlog(final String waterQuantity1, final String date1, final String time1) {
    	this.waterQuantity = waterQuantity1;
    	this.date = date1;
    	this.time = time1;
    }
    /**
     * getting water qunatity.
     *
     * @return waterquantity.
     */
    String getWaterQuatity() {
    	return this.waterQuantity;
    }
    /**
     * setting water quantity.
     *
     * @param quantity quantity.
     */
    void setWaterQuantity(final String quantity) {
    	this.waterQuantity = quantity;
    }
    public String wshow() {
    	System.out.println("Water");
    	return "Date:" + date + "\nQuantity:" + waterQuantity + "ml";
    }
}
/**
 * activity class.
 */
class Activity {
	/**
	 * declaring activity.
	 */
	private String activityname;
	/**
	 * declaring date.
	 */
	private String date;
	/**
	 * declaring start time.
	 */
	private String starttime;
	/**
	 * declaring end time.
	 */
	private String endtime;
	/**
	 * declaring notes.
	 */
	private String notes;
	/**
	 * constructor activity.
	 * 
	 * @param activityname1 String.
	 * @param date1 String.
	 * @param starttime1 String.
	 * @param endtime1 String.
	 * @param notes1 String.
	 */
	Activity(final String activityname1, final String notes1, final String date1, final String starttime1, final String endtime1) {
		this.activityname = activityname1;
	    this.date = date1;
	    this.starttime = starttime1;
	    this.endtime = endtime1;
	    this.notes = notes1;
	}
	public String ashow() {
		System.out.println("PhysicalActivity");
		return "Name:" + activityname + "\nNotes:" + notes + "\nDate:" + date + "\nstarttime:" + starttime +"\nendtime:" + endtime;
	}
}
/**
 * weight class.
 */
class Weight {
	/**
	 * declaring weight
	 */
	private String weightinkg;
	/**
	 * declaring fat percent.
	 */
	private String fat;
	/**
	 * declaring date.
	 */
	private String date;
	private String time;
	/**
	 * weight constructor.
	 * 
	 * @param weightinkg1 weigth.
	 * @param fat1 fat percent.
	 * @param date1 date.
	 */
	Weight(final String date1, final String time1, final String weightinkg1, final String fat1) {
        this.date = date1;
		this.time = time1;
		this.weightinkg = weightinkg1;
		this.fat = fat1;
	}
	public String weshow() {
		System.out.println("Weight");
		return "Date:" + date + "\nTime:" + time + "\nWeight:" + weightinkg + "\nFat:" + fat;
	}
}
/**
 * class sleep
 */
class Sleep {
	/**
	 * declaring date and starttime. 
	 */
	private String start;
	/**
	 * declaring date and end time.
	 */
	private String end;
	private String date;
	/**
	 * constructor for sleep contains start and end time.
	 *
	 * @param datestart1 strig.
	 * @param dateend1 string.
	 */
	Sleep(String date1, String start1, String end1) {
		this.date = date1;
		this.start = start1;
		this.end = end1;
	}
	/**
	 * get start time.
	 *
	 * @return datestart.
	 */
	String getStart() {
		return this.start;
	}
	/**
	 * set start time.
	 *
	 * @param start start time.
	 */
	void setStart(final String start) {
        this.start = start;
	}
	/**
	 * get settime.
	 *
	 * @return dateend.
	 */
	String getEnd() {
		return this.end;
	}
	/**
	 * set endtime.
	 *
	 * @param end endtime.
	 */
	void setEnd(final String end) {
		this.end = end;
	}
	public String sshow() {
		System.out.println("Sleep");
		return "Date:" + date + "\nStarttime:" + start + "\nEndtime:" + end; 
	}
}

/**
 * solution class.
 */
public final class Solution {
	/**
	 * @default constructor.
	 */
	private Solution() {

	}
	/**
	 * main class.
	 * @param args the arguments.
	 */
	public static void main(final String[] args) {
        Log log = new Log();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] token = scan.nextLine().split(",");
            String[] check = token[0].split(" ");
            switch (check[0]) {
            	case "Food":
            	Foodlog f = new Foodlog(check[1], Integer.parseInt(token[1]), token[2], token[3]);
            	log.addToFood(f);
            	break;
            	case "Water":
            	Waterlog w = new Waterlog(check[1], token[1], token[2]);
            	log.addToWater(w);
            	break;
            	case "PhysicalActivity":
            	Activity a = new Activity(check[1], token[1], token[2], token[3], token[4]);
            	log.addToActivity(a);
            	break;
            	case "Weight":
            	Weight e = new Weight(check[1], token[1], token[2], token[3]);
            	log.addToWeight(e);
            	break;
            	case "Sleep":
            	Sleep s = new Sleep(check[1], token[1], token[2]);
            	log.addToSleep(s);
            	break;
            	case "Foodlog":
            	log.foodl();
            	break;
            	case "Waterlog":
                log.waterl();
                break;
            	case "PhysicalActivitylog":
            	log.physical();
            	break;
            	case "Weightlog":
            	log.weight();
            	break;
            	case "Sleeplog":
            	log.sleep();
            	break;
            	case "Summary":
            	log.summary();
            	break;
            	default:
            	break;
            }
        }
	}
}