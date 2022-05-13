package FoodSuplier;

// import libraries
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date class is a deprecated yet still
 * useful class that we will use as the 
 * keys in our next Map project.  
 * Use this file to get familiar with the basic operations
 * you will need when using this object type.
 */
public class DateStarterKit {

	public static void main(String[] args) throws ParseException {

		// Using SimpleDateFormat allows us to format a Date object to print differently than its toString suggests.
		String pattern = "MM-dd-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		//A. Simplest instantiation & print process
		Date date = new Date(); //no-arg constructor takes clock time argument
		System.out.println("Example A1: " + date); // toString as supported by Java API
		System.out.println("Example A2: " + simpleDateFormat.format(date) + "\n");  //using simpleDateFormat, similar to DecimalFormat for numbers
		
		
		//B.  Examples of overloaded constructor
		date = new Date(1950, 2, 25);
		System.out.println("Example B1: " + simpleDateFormat.format(date)+ "\n"); // notice how the numbers are "off"
		
		date = new Date(1950-1900, 2-1, 25);
		System.out.println("Example B2: " + simpleDateFormat.format(date)+ "\n"); // adjustments to year and month are needed due to the weird constructor
		
		
		
		//C.  Parsing Dates in order to make them equal
		Date d1 = new Date();
		d1.setYear(105);
		d1.setMonth(10);
		d1.setDate(10);
		System.out.println("Example C:\nDate 1: " + simpleDateFormat.format(d1));
		Date d2 = new Date(105,10,10);
		System.out.println("Date 2: " + simpleDateFormat.format(d2));
		System.out.println("Date 1 equals Date2: " + d1.equals(d2)); // Strange, right?  
//		Why do you suppose this happens - the dates print out exactly the same?!
		
//		Now watch this:
		System.out.println("\n\nExample D:\nNow watch this:");
		System.out.println("Here are the dates, printed again, but including all their info:");
		System.out.println(d1);
		System.out.println(d2);
		System.out.println("\nDepending on how you created the Date object, time information"
				+ "can be included...sometimes it is hard to detect.\n"
				+ "You can use a parsing process to leave just the month, date, and year"
				+ "in the Date object - allowing true 'date' comparison between objects");
		d1 = simpleDateFormat.parse(simpleDateFormat.format(d1));
		d2 = simpleDateFormat.parse(simpleDateFormat.format(d2));
		System.out.println("Date 1: " + d1);
		System.out.println("Date 2: " + d2);
		System.out.println("Date 1 equals Date2: " + d1.equals(d2) + "\n\n"); 
// 		So the parsing removes all 'time' information, allowing the two dates to be equal.
//		This will be important since we will be using Date objects as map keys, which 
//		are not equal if the dates are same but the times are not the same.
//		If you find that your get(key) returns null, when you are sure you create
//		a map properly, then it is likely that this false equality of Date objects
//		is happening.
		
//		Let's make two dates and compare them, since Date implements Comparable:
		Date d3 = new Date(110, 4, 29);
		Date d4 = new Date(110, 5, 1);
		System.out.println("new dates" + d3 + d4);
//		remember, we should 'sanitize' the time info and leave only the dates
//		even though we know the day is different..
		d3 = simpleDateFormat.parse(simpleDateFormat.format(d3));
		d4 = simpleDateFormat.parse(simpleDateFormat.format(d4));
		System.out.println("Date 3: " + d3);
		System.out.println("Date 4: " + d4);
		System.out.println(simpleDateFormat.format(d3) + " comes " + ((d3.compareTo(d4)< 0) ? "before ":"after ") + simpleDateFormat.format(d4));
		System.out.println(simpleDateFormat.format(d2) + " comes " + ((d2.compareTo(d4)< 0) ? "before ":"after ") + simpleDateFormat.format(d4));
		
			
		//following is not in our project, but useful elsewhere perhaps
		date.setDate(date.getDate() + 10);
		System.out.println(simpleDateFormat.format(date)+ "\n"); // adjustments to year and month are needed
		
	}

}