package FoodSuplier;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.*;
public class FoodSuplier {
	Map<Date, LinkedList<orders>> menu;
	public FoodSuplier() {
		menu = new HashMap<Date, LinkedList<orders>>();
	}
	public static String printMenuAndGetChoice() {
		System.out.println("********Food Suplier Database********");
		   System.out.println("Access Database Methods:\n(1)what date had the most orders of (item)(Mr.S developed)?\n(2)what company ordered the most (item)((Mr.S developed))?\n(3)which company ordered the most (item) in a (given year)"
		   		+ "((Mr.S developed))? (2 parameters)\n(4)All Orders in given day((Mr.S developed))\n(5)"
		   		+ "All Orders in given month((Mr.S developed))"
		   		+ "\n(6)Duplicate orders in given day((Mr.S developed))"
		   		+ "\n(7)Companys that ordered at least a given number of items in a given year((Mr.S developed))"
		   		+ "\n(8)all orders of company in given date interval((Mr.S developed))"
		   		+ "\n(9)Total order summary for a given company in a given date interval((Mr.S developed))"
		   		+ "\n(10) total amount of one (product) ordered in a given Date interval((Mr.S developed))"
		   		+ "\n(11)How much money was collected on given day((Mr.S developed))"
		   		+ "\n(12)How much money was collected on given date interval((Mr.S developed))"
		   		+ "\n(13)billing statement for a given company in a given Date interval(Mr.S developed)"
		   		+ "\n(14)Add new order to current supplyOrders file(Mr.S developed)"
		   		+ "\n(15)choose the output format for your reports(Mr.S developed)"
		   		+ "\n(16)Add order and total order price to new file in REPORTS(Student Developed)"
		   		+ "\n(17)Get all Restaurant Names(Student Developed)"
		   		+ "\n(18)get restaurant with most number of individual stores(Student Developed)\nEnter Numbers Above to Access Those Functions:");
			Scanner sc = new Scanner(System.in);
		   return sc.nextLine();
		   }
	public void add(String line) {
		String[] split = line.split(" ");
		String[] dateFinesse = split[0].split("-");
		Date d = new Date(Integer.parseInt(dateFinesse[2])-1900, Integer.parseInt(dateFinesse[0])-1, Integer.parseInt(dateFinesse[1]));
		orders o = new orders();
		String CompanyName = split[1].substring(0, split[1].indexOf("#"));
		String IndividualRestraurantName = split[1].substring(split[1].indexOf("#"));
		o.setCompanyName(CompanyName);
		o.setIndividualRestraurantName(IndividualRestraurantName);
		for(int i = 2; i < split.length; i++) {
			if(split[i].contains("burgers")) {
				String[] thing = split[i].split("-");
				o.setBurgers(Integer.parseInt(thing[1]));
			}
			else if(split[i].contains("buns")) {
				String[] thing = split[i].split("-");
				o.setBuns(Integer.parseInt(thing[1]));
			}
			else if(split[i].contains("cups")) {
				String[] thing = split[i].split("-");
				o.setCups(Integer.parseInt(thing[1]));
			}
			else if(split[i].contains("straws")) {
				String[] thing = split[i].split("-");
				o.setStraws(Integer.parseInt(thing[1]));
			}
			else if(split[i].contains("cokesyrup")) {
				String[] thing = split[i].split("-");
				o.setCokesyrup(Integer.parseInt(thing[1]));
			}
			else if(split[i].contains("fries")) {
				String[] thing = split[i].split("-");
				o.setFries(Integer.parseInt(thing[1]));
			}
			else if(split[i].contains("napkins")) {
				String[] thing = split[i].split("-");
				o.setNapkins(Integer.parseInt(thing[1]));
			}

		}
		if(menu.containsKey(d)) {
			LinkedList<orders> LLorder = menu.get(d);
			LLorder.add(o);
			menu.put(d, LLorder);
		}
		else {
			LinkedList<orders> LLorder = new LinkedList<orders>();
			LLorder.add(o);
			menu.put(d, LLorder);
		}
	}
	//get all restaurant names(Student Developed)
	public Set<String> getAllRestaurant(){
		Set<String> res = new HashSet<String>();
		for(Date a : menu.keySet()) {
			for(orders b: menu.get(a)) {
				res.add(b.companyName);
			}
		}
		return res;
	}
	//get restaurant with most number of individual stores(Student Developed)
	public void resturantMostStores(){
		Set<String> res = this.getAllRestaurant();
		int max = 0;
		String ress = "";
		for(String com: res) {
			ArrayList<String> stores = new ArrayList<String>();
			for(Date a : menu.keySet()) {
				for(orders b : menu.get(a)) {
					if(b.getCompanyName().equals(com))
						stores.add(b.getIndividualRestraurantName());
				}
			}
			if(max<stores.size()) {
				max = stores.size();
				ress=com;
			}
		}
		System.out.println("Company with the most amount of individual stores being " + max + " stores is: " + ress);
		
	}
	
	//returns Date of most orders of product -  Mr.S developed 
	public Date mostOrders(String product) {
		int max = 0;
		Date b = null;
		for(Date a : menu.keySet()) {
			int count = 0;
			for(orders c : menu.get(a)) {
				count+=c.get(product);
			}
			if(count > max) {
				max = count;
				b = a;
			}
		}
		return b;
	}	
	//returns Company with most orders of product -  Mr.S developed 
	public String mostOrdersCompany(String product) {
		Map<String, Integer> Company = new HashMap<String, Integer>();
		for(Date a : menu.keySet()) {
			for(orders b : menu.get(a)) {
				if(!Company.containsKey(b.getCompanyName()))
				{
					Company.put(b.getCompanyName(), b.get(product));
				}
				else
					Company.put(b.getCompanyName(), Company.get(b.getCompanyName()) + b.get(product));
			}
		}
		int max = 0;
		String b = null;
		for(String a : Company.keySet()) {
			if(Company.get(a) > max) {
				max = Company.get(a);
				b = a;
			}
		}
		return b;
	}
	//which store went the longest between orders, in days ?
//	public String mostGapDate() {
//		int max = 0;
//		for(Date a : menu.keySet())
//	}
	//returns Company with most orders of product in a given year -  Mr.S developed
	public String mostOrdersInYear(String product, int date) {
		Map<String, Integer> Company = new HashMap<String, Integer>();
		for(Date a : menu.keySet()) {
			if(a.getYear()==(date-1900)) {
				for(orders b : menu.get(a)) {
					if(!Company.containsKey(b.getCompanyName()))
					{
						Company.put(b.getCompanyName(), b.get(product));
					}
					else
						Company.put(b.getCompanyName(), Company.get(b.getCompanyName()) + b.get(product));
				}
			}
		}
		int max = 0;
		String b = null;
		for(String a : Company.keySet()) {
			if(Company.get(a) > max) {
				max = Company.get(a);
				b = a;
			}
		}
		return b;
	}
	//returns a Set of all orders in a given day -  Mr.S developed
	public Set<orders> allInGivenDay(Date date) {
		Set<orders> o = new HashSet<orders>();
		for(Date a : menu.keySet()) {
			if(a.compareTo(date)==0) {
				for(orders b : menu.get(a)) {
					o.add(b);
				}
			}
		}

		return o;
	}
	//returns a Set of all orders in a given month -  Mr.S developed
	public Set<orders> allInGivenMonth(Date date) {
		Set<orders> o = new HashSet<orders>();
		for(Date a : menu.keySet()) {
			if(a.getMonth() == date.getMonth() && a.getYear() == date.getYear()) {
				for(orders b : menu.get(a)) {
					o.add(b);
				}
			}
		}
		return o;
	}
	//return a set of the companies that ordered at least a (given number) of (burgers)
	//in a (given year) (3 parameters)   -  Mr.S developed
	public Set<String> minProductYear(int num, String product, int date){
		Set<String> c = new HashSet<String>();
		Map<String, Integer> Company = new HashMap<String, Integer>();
		for(Date a : menu.keySet()) {
			if(a.getYear()==(date-1900)){
				for(orders b : menu.get(a)) {
					if(b.get(product) > num) {
						if(!Company.containsKey(b.getCompanyName()))
						{
							Company.put(b.getCompanyName(), b.get(product));
						}
						else
							Company.put(b.getCompanyName(), Company.get(b.getCompanyName()) + b.get(product));
					}
				}
			}
		}
		for(String a : Company.keySet()) {
			c.add(a);
		}
		return c;
	} 
	//return a set of duplicate orders of a given day - (use 1-9-2010 to test)	- Mr.S developed
	public Set<orders> allDuplicatesDay(Date date) {
		Set<orders> o = new HashSet<orders>();
		for(Date a : menu.keySet()) {
			if(a.equals(date)) {
				for(orders b : menu.get(a)) {
					//traverse linkedlist search for dupes and then add to o
					for(orders c : menu.get(a)) {
						if(b.straws == c.straws && b.buns == c.buns && b.burgers == c.burgers &&
								b.cokesyrup == c.cokesyrup && b.napkins == c.napkins &&
								b.cups == c.cups && b.fries == c.fries
								&& !b.equals(c))
							o.add(b);
					}
				}
			}
		}
		return o;
	}

	//return a set of all of the orders for a given (company) in a given Date interval (3 parameters) Mr.S developed
	public Set<orders> allCompanyOrdersInDate(Date date, Date date2, String companyName) {
		Set<orders> o = new HashSet<orders>();
		for(Date a : menu.keySet()) {
			if(a.compareTo(date) > 0 &&  a.compareTo(date2) < 0 ) {
				for(orders b : menu.get(a)) {
					if(b.getCompanyName().equals(companyName))
						o.add(b);
				}
			}
		}
		return o;
	}

	//print out a summary/total for orders from a given (company) in a given Date interval (3 parameters) - Mr.S developed
	public void SumCompanyOrdersInDate(Date date, Date date2, String companyName) {
		orders order = new orders();
		Set<orders> o = new HashSet<orders>();
		for(Date a : menu.keySet()) {
			if(a.compareTo(date) > 0 &&  a.compareTo(date2) < 0 ) {
				for(orders b : menu.get(a)) {
					if(b.getCompanyName().equals(companyName))
					{
						order.setBuns(order.getBuns() + b.getBuns());
						order.setBurgers(order.getBurgers() + b.getBurgers());
						order.setCokesyrup(order.getCokesyrup() + b.getCokesyrup());
						order.setCompanyName(companyName);
						order.setCups(order.getCups() + b.getCups());
						order.setFries(order.getFries() + b.getFries());;
						order.setStraws(order.getStraws() + b.getStraws());;
					}
				}
			}
		}
		System.out.println("Company Name: " + order.companyName +   " Napkins: " + order.napkins +  " straws: " + order.straws +  " cups: " + order.cups +  " coke syrup: " + order.cokesyrup +  " fries: " + order.fries +  " buns: " + order.buns + " burgers: " + order.burgers);
	}
	//print the total amount of one (product) ordered in a given Date interval (3 parameters) - Mr.S developed
	public void allProductsInDate(Date date, Date date2, String product) {
		int count = 0;
		for(Date a : menu.keySet()) {
			if(a.compareTo(date) > 0 &&  a.compareTo(date2) < 0 ) {
				for(orders b : menu.get(a)) {
					count+=b.get(product);
				}
			}
		}
		System.out.println("The number of "+ product + " in the date interval of " + date + " and " + date2 + " is: " + count);
	}
	//which store went the longest between orders, in days ? - Mr.S developed
	public void longestBetweenStore() {
		int max = 0;
		Set<String> res = this.getAllRestaurant();
		for(String com : res) {
			int interval = 0;
			Date one;
		for(Date a : menu.keySet()) {
			for(orders b : menu.get(a)) {
				if(b.getCompanyName().equals(com)) {
					one = a;
				}
			}
		}
		}
		System.out.println("");
	}
	// - Mr S Developed
	public void addToDatabase(Date date, orders a) throws IOException {
		FileWriter file = new FileWriter("H:\\workspace2021\\Maps\\src\\FoodSupplier\\supplyOrders.dat", true);
		BufferedWriter br = new BufferedWriter(file);
		file.append("\n"  + date.getMonth()+1 + "-" + date.getDate() + "-" + (date.getYear() + 1900) + " " + a.fileFormat());
		file.close();
	}
	//add file to a directory named reports - Mr S Developed
	public void outputFormat(boolean format, String fileName, orders a, Date date) throws IOException{
		if(format) {
			FileWriter file = new FileWriter(new File("H:\\workspace2021\\Maps\\src\\FoodSupplier\\REPORTS\\"+ fileName + ".txt"));
			file.write(date.getMonth()+1 + "-" + date.getDate() + "-" + date.getYear() + 1900 + " " + a.fileFormat());
		}
		else if(fileName.equals("") && !format) {
			System.out.println(a.fileFormat());
		}
	}

	/*
	 * Develop a basic price list for your products – (this should not be a part of the Order class.)
	Then, implement methods that will utilize those price values. Examples include:
	 how much money was collected on a given Date (parameter)
	 how much money was collected in a given Date interval (2 parameters)
	 print a billing statement for a given company in a given Date interval (3 parameters)
	 */
	//Mr S Developed
	public double moneyCollectedOnDay(Date date) {
		Map<String, Integer> priceList = new HashMap<String, Integer>();
		priceList.put("buns", 0);
		priceList.put("burgers", 0);
		priceList.put("straws", 0);
		priceList.put("cokesyrup", 0);
		priceList.put("cups", 0);
		priceList.put("napkins", 0);
		priceList.put("fries", 0);
		Map<String, Double> ActualpriceList = new HashMap<String, Double>();
		ActualpriceList.put("buns", 5.99);
		ActualpriceList.put("burgers", 6.22);
		ActualpriceList.put("straws", 3.00);
		ActualpriceList.put("cokesyrup", 2.99);
		ActualpriceList.put("cups", 5.42);
		ActualpriceList.put("napkins", 1.52);
		ActualpriceList.put("fries", 9.24);
		ArrayList<String> items = new ArrayList<String>();
		items.add("buns");
		items.add("burgers");
		items.add("cokesyrup");
		items.add("cups");
		items.add("napkins");
		items.add("fries");
		items.add("straws");
		for(Date a : menu.keySet()) {
			if(a.getDay() == date.getDay() && a.getMonth() == date.getMonth() && a.getYear() == date.getYear()) {
				for(orders b : menu.get(a)) {
					for(String product: items) {
						priceList.put(product, priceList.get(product) + b.get(product));
					}
				}
			}
		}
		double totalPrice = 0.00;
		for(String product: priceList.keySet()) {
			totalPrice+=(ActualpriceList.get(product)*priceList.get(product));
		}
		return totalPrice;
	}
	//Mr S Developed
	public double moneyCollectedOnDayInterval(Date date, Date date2) {
		Map<String, Integer> priceList = new HashMap<String, Integer>();
		priceList.put("buns", 0);
		priceList.put("burgers", 0);
		priceList.put("straws", 0);
		priceList.put("cokesyrup", 0);
		priceList.put("cups", 0);
		priceList.put("napkins", 0);
		priceList.put("fries", 0);
		Map<String, Double> ActualpriceList = new HashMap<String, Double>();
		ActualpriceList.put("buns", 5.99);
		ActualpriceList.put("burgers", 6.22);
		ActualpriceList.put("straws", 3.00);
		ActualpriceList.put("cokesyrup", 2.99);
		ActualpriceList.put("cups", 5.42);
		ActualpriceList.put("napkins", 1.52);
		ActualpriceList.put("fries", 9.24);
		ArrayList<String> items = new ArrayList<String>();
		items.add("buns");
		items.add("burgers");
		items.add("cokesyrup");
		items.add("cups");
		items.add("napkins");
		items.add("fries");
		items.add("straws");
		for(Date a : menu.keySet()) {
			if(a.compareTo(date) > 0 &&  a.compareTo(date2) < 0) {
				for(orders b : menu.get(a)) {
					for(String product: items) {
						priceList.put(product, priceList.get(product) + b.get(product));
					}
				}
			}
		}
		double totalPrice = 0.00;
		for(String product: priceList.keySet()) {
			totalPrice+=(ActualpriceList.get(product)*priceList.get(product));
		}
		return totalPrice;
	}
	//Mr S Developed
	public void billingStatementCompanyCollectedOnDayInterval(Date date, Date date2, String companyName) {
		Map<String, Integer> priceList = new HashMap<String, Integer>();
		priceList.put("buns", 0);
		priceList.put("burgers", 0);
		priceList.put("straws", 0);
		priceList.put("cokesyrup", 0);
		priceList.put("cups", 0);
		priceList.put("napkins", 0);
		priceList.put("fries", 0);
		Map<String, Double> ActualpriceList = new HashMap<String, Double>();
		ActualpriceList.put("buns", 5.99);
		ActualpriceList.put("burgers", 6.22);
		ActualpriceList.put("straws", 3.00);
		ActualpriceList.put("cokesyrup", 2.99);
		ActualpriceList.put("cups", 5.42);
		ActualpriceList.put("napkins", 1.52);
		ActualpriceList.put("fries", 9.24);
		ArrayList<String> items = new ArrayList<String>();
		items.add("buns");
		items.add("burgers");
		items.add("cokesyrup");
		items.add("cups");
		items.add("napkins");
		items.add("fries");
		items.add("straws");
		String statement = "Billing Statement for " + companyName;
		for(Date a : menu.keySet()) {
			if(a.compareTo(date) > 0 &&  a.compareTo(date2) < 0) {
				for(orders b : menu.get(a)) {
					if(b.getCompanyName().equals(companyName)) {
						for(String product: items) {
							priceList.put(product, priceList.get(product) + b.get(product));
						}
					}
				}
			}
		}
		double totalPrice = 0.00;
		for(String product: priceList.keySet()) {
			totalPrice+=(ActualpriceList.get(product)*priceList.get(product));
			statement+= product + " - $" + (ActualpriceList.get(product)*priceList.get(product)) + "\n";
		}
		System.out.println(statement);
	}
	//Add order and total order price to new file in REPORTS(Student Developed)
	public void addOrderAndPriceToFile(String FileName, orders a, Date date) throws IOException {
		Map<String, Integer> priceList = new HashMap<String, Integer>();
		priceList.put("buns", 0);
		priceList.put("burgers", 0);
		priceList.put("straws", 0);
		priceList.put("cokesyrup", 0);
		priceList.put("cups", 0);
		priceList.put("napkins", 0);
		priceList.put("fries", 0);
		Map<String, Double> ActualpriceList = new HashMap<String, Double>();
		ActualpriceList.put("buns", 5.99);
		ActualpriceList.put("burgers", 6.22);
		ActualpriceList.put("straws", 3.00);
		ActualpriceList.put("cokesyrup", 2.99);
		ActualpriceList.put("cups", 5.42);
		ActualpriceList.put("napkins", 1.52);
		ActualpriceList.put("fries", 9.24);
		ArrayList<String> items = new ArrayList<String>();
		items.add("buns");
		items.add("burgers");
		items.add("cokesyrup");
		items.add("cups");
		items.add("napkins");
		items.add("fries");
		items.add("straws");
		int price = 0;
		price+=a.getBuns()*ActualpriceList.get("buns");
		price+=a.getBurgers()*ActualpriceList.get("burgers");
		price+=a.getCokesyrup()*ActualpriceList.get("cokesyrup");
		price+=a.getCups()*ActualpriceList.get("cups");
		price+=a.getNapkins()*ActualpriceList.get("napkins");
		price+=a.getFries()*ActualpriceList.get("fries");
		price+=a.getStraws()*ActualpriceList.get("straws");
		
		FileWriter file = new FileWriter(new File("H:\\workspace2021\\Maps\\src\\FoodSupplier\\REPORTS\\"+ FileName + ".txt"));
		file.write("Total Price: $" + price+ " "+ date.getMonth()+1 + "-" + date.getDate() + "-" + date.getYear() + 1900 + " " + a.fileFormat());
	}
	public String toString() {
		String output = "";
		String pattern = "MM-dd-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		for(Date a: menu.keySet())
		{
			output+="Date: " + simpleDateFormat.format(a) + " Orders: " + menu.get(a).toString() + "\n";
		}
		return output;
	}
}
