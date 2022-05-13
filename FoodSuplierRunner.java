package FoodSuplier;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class FoodSuplierRunner {
	public static void main(String[] args) throws IOException {
		FileReader file = new FileReader(new File("H:\\workspace2021\\Maps\\src\\FoodSupplier\\supplyOrders.dat"));
		BufferedReader br = new BufferedReader(file);
		int num = Integer.parseInt(br.readLine());
		FoodSuplier f = new FoodSuplier();
		for(int i = 0; i < num; i++) {
			f.add(br.readLine());
		}
		//		String pattern = "MM-dd-yyyy";
		//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		//		System.out.println(f);
		//		String item = "burgers";
		//		int year = 2015;
		//		String d = "1-9-2010";
		//		orders h = new orders();
		//		String[] dateFinesse = d.split("-");
		//		int num2 = 4;
		//		Date date = new Date(Integer.parseInt(dateFinesse[2])-1900, Integer.parseInt(dateFinesse[0])-1, Integer.parseInt(dateFinesse[1]));
		//		System.out.println("Date with the most orders of " + item  + ": " + simpleDateFormat.format(f.mostOrders(item)).toString());
		//		System.out.println("Company with the most orders of " + item  + ": " + f.mostOrdersCompany(item));
		//		System.out.println("Company with the most orders of " + item  + " in year " + year + ": " + f.mostOrdersInYear(item,year));
		//		System.out.println("Set of all orders in day " + d + ": " + f.allInGivenDay(date));
		//		System.out.println("Set of all companies that had a minimum of " + num2  + " " + item + " in the date " + f.minProductYear(num2,item,date));
		//		System.out.println("Set of duplicates in date " + d  + " :" +  f.allDuplicatesDay(date));
		//		f.addToDatabase(item, h);
		//make scanner, use student grade map 
		int hi = 0;
		while(hi!=1) {
			String op = f.printMenuAndGetChoice();

			if(op.equals("1"))
			{
				System.out.println("Enter Item");
				Scanner sc = new Scanner(System.in);
				String product = sc.nextLine();
				System.out.println(f.mostOrders(product));
			}
			if(op.equals("2"))
			{
				System.out.println("Enter Item");
				Scanner sc = new Scanner(System.in);
				String product = sc.nextLine();
				System.out.println(f.mostOrdersCompany(product));
			}
			if(op.equals("3"))
			{
				System.out.println("Enter Item");
				Scanner sc = new Scanner(System.in);
				String product = sc.nextLine();
				System.out.println("Enter Year");
				int year = Integer.parseInt(sc.nextLine());
				System.out.println(f.mostOrdersInYear(product, year)); 
			}
			if(op.equals("4"))
			{
				System.out.println("Enter date MM-dd-yyyy format");
				Scanner sc = new Scanner(System.in);
				String date1 = sc.nextLine();
				String[] dateFinesse = date1.split("-");
				Date d = new Date(Integer.parseInt(dateFinesse[2])-1900, Integer.parseInt(dateFinesse[0])-1, Integer.parseInt(dateFinesse[1]));
				System.out.println(f.allInGivenDay(d).toString());	

			}
			if(op.equals("5"))
			{
				System.out.println("Enter date MM-dd-yyyy format");
				Scanner sc = new Scanner(System.in);
				String date1 = sc.nextLine();
				String[] dateFinesse = date1.split("-");
				Date d = new Date(Integer.parseInt(dateFinesse[2])-1900, Integer.parseInt(dateFinesse[0])-1, Integer.parseInt(dateFinesse[1]));
				System.out.println(f.allInGivenMonth(d).toString());
			}
			if(op.equals("6"))
			{
				System.out.println("Enter date MM-dd-yyyy format");
				Scanner sc = new Scanner(System.in);
				String date1 = sc.nextLine();
				String[] dateFinesse = date1.split("-");
				Date d = new Date(Integer.parseInt(dateFinesse[2])-1900, Integer.parseInt(dateFinesse[0])-1, Integer.parseInt(dateFinesse[1]));
				System.out.println(f.allDuplicatesDay(d));

			}
			if(op.equals("7"))
			{
				System.out.println("Enter Year");
				Scanner sc = new Scanner(System.in);
				int date1 = Integer.parseInt(sc.nextLine());

				System.out.println("Enter item");
				String item = sc.nextLine();

				System.out.println("Enter base number line for " + item);
				String itemnum = sc.nextLine();

				System.out.println(f.minProductYear(Integer.parseInt(itemnum), item, date1).toString());
			}
			if(op.equals("8"))
			{
				System.out.println("Enter first date interval MM-dd-yyyy format");
				Scanner sc = new Scanner(System.in);
				String date1 = sc.nextLine();
				String[] dateFinesse = date1.split("-");
				Date d = new Date(Integer.parseInt(dateFinesse[2])-1900, Integer.parseInt(dateFinesse[0])-1, Integer.parseInt(dateFinesse[1]));

				System.out.println("Enter first date interval MM-dd-yyyy format");
				String date12 = sc.nextLine();
				String[] dateFinesse2 = date1.split("-");
				Date d2 = new Date(Integer.parseInt(dateFinesse2[2])-1900, Integer.parseInt(dateFinesse2[0])-1, Integer.parseInt(dateFinesse2[1]));

				System.out.println("Enter company name");
				String copany = sc.nextLine();
				//String[] dateFinesse = date1.split("-");
				//Date d = new Date(Integer.parseInt(dateFinesse[2])-1900, Integer.parseInt(dateFinesse[0])-1, Integer.parseInt(dateFinesse[1]));

				System.out.println(f.allCompanyOrdersInDate(d,d2,copany));

			}
			if(op.equals("9"))
			{
				System.out.println("Enter first date interval MM-dd-yyyy format");
				Scanner sc = new Scanner(System.in);
				String date1 = sc.nextLine();
				String[] dateFinesse = date1.split("-");
				Date d = new Date(Integer.parseInt(dateFinesse[2])-1900, Integer.parseInt(dateFinesse[0])-1, Integer.parseInt(dateFinesse[1]));

				System.out.println("Enter first date interval MM-dd-yyyy format");
				String date12 = sc.nextLine();
				String[] dateFinesse2 = date1.split("-");
				Date d2 = new Date(Integer.parseInt(dateFinesse2[2])-1900, Integer.parseInt(dateFinesse2[0])-1, Integer.parseInt(dateFinesse2[1]));
				System.out.println("Enter company name");
				String copany = sc.nextLine();
				//String[] dateFinesse = date1.split("-");
				//Date d = new Date(Integer.parseInt(dateFinesse[2])-1900, Integer.parseInt(dateFinesse[0])-1, Integer.parseInt(dateFinesse[1]));
				f.SumCompanyOrdersInDate(d,d2,copany);
			}
			if(op.equals("10"))
			{
				System.out.println("Enter first date interval MM-dd-yyyy format");
				Scanner sc = new Scanner(System.in);
				String date1 = sc.nextLine();
				String[] dateFinesse = date1.split("-");
				Date d = new Date(Integer.parseInt(dateFinesse[2])-1900, Integer.parseInt(dateFinesse[0])-1, Integer.parseInt(dateFinesse[1]));

				System.out.println("Enter first date interval MM-dd-yyyy format");
				String date12 = sc.nextLine();
				String[] dateFinesse2 = date1.split("-");
				Date d2 = new Date(Integer.parseInt(dateFinesse2[2])-1900, Integer.parseInt(dateFinesse2[0])-1, Integer.parseInt(dateFinesse2[1]));

				System.out.println("Enter item name");
				String copany = sc.nextLine();
				//String[] dateFinesse = date1.split("-");
				//Date d = new Date(Integer.parseInt(dateFinesse[2])-1900, Integer.parseInt(dateFinesse[0])-1, Integer.parseInt(dateFinesse[1]));

				System.out.println(f.allCompanyOrdersInDate(d,d2,copany));
			}
			if(op.equals("11"))
			{
				System.out.println("Enter first date interval MM-dd-yyyy format");
				Scanner sc = new Scanner(System.in);
				String date1 = sc.nextLine();
				String[] dateFinesse = date1.split("-");
				Date d = new Date(Integer.parseInt(dateFinesse[2])-1900, Integer.parseInt(dateFinesse[0])-1, Integer.parseInt(dateFinesse[1]));
				System.out.println(f.moneyCollectedOnDay(d));
			}
			if(op.equals("12"))
			{
				System.out.println("Enter first date interval MM-dd-yyyy format");
				Scanner sc = new Scanner(System.in);
				String date1 = sc.nextLine();
				String[] dateFinesse = date1.split("-");
				Date d = new Date(Integer.parseInt(dateFinesse[2])-1900, Integer.parseInt(dateFinesse[0])-1, Integer.parseInt(dateFinesse[1]));

				System.out.println("Enter first date interval MM-dd-yyyy format");
				String date12 = sc.nextLine();
				String[] dateFinesse2 = date1.split("-");
				Date d2 = new Date(Integer.parseInt(dateFinesse2[2])-1900, Integer.parseInt(dateFinesse2[0])-1, Integer.parseInt(dateFinesse2[1]));
				System.out.println(f.moneyCollectedOnDayInterval(d, d2));
			}
			if(op.equals("13"))
			{
				System.out.println("Enter first date interval MM-dd-yyyy format");
				Scanner sc = new Scanner(System.in);
				String date1 = sc.nextLine();
				String[] dateFinesse = date1.split("-");
				Date d = new Date(Integer.parseInt(dateFinesse[2])-1900, Integer.parseInt(dateFinesse[0])-1, Integer.parseInt(dateFinesse[1]));

				System.out.println("Enter first date interval MM-dd-yyyy format");
				String date12 = sc.nextLine();
				String[] dateFinesse2 = date1.split("-");
				Date d2 = new Date(Integer.parseInt(dateFinesse2[2])-1900, Integer.parseInt(dateFinesse2[0])-1, Integer.parseInt(dateFinesse2[1]));
				System.out.println("Enter company name");
				String copany = sc.nextLine();
				//String[] dateFinesse = date1.split("-");
				//Date d = new Date(Integer.parseInt(dateFinesse[2])-1900, Integer.parseInt(dateFinesse[0])-1, Integer.parseInt(dateFinesse[1]));
				f.billingStatementCompanyCollectedOnDayInterval(d, d, copany);
			}
			if(op.equals("14"))
			{
				System.out.println("Enter date MM-dd-yyyy format");
				Scanner sc = new Scanner(System.in);
				String date1 = sc.nextLine();
				String[] dateFinesse = date1.split("-");
				Date d = new Date(Integer.parseInt(dateFinesse[2])-1900, Integer.parseInt(dateFinesse[0])-1, Integer.parseInt(dateFinesse[1]));
				orders wow = new orders();
				System.out.println("Enter Company Name");
				String company = sc.nextLine();
				wow.setCompanyName(company);
				System.out.println("Enter Individual Store Number Ex-#32");
				String indi = sc.nextLine();
				wow.setIndividualRestraurantName(indi);
				System.out.println("Enter # of buns");
				String bun = sc.nextLine();
				wow.setBuns(Integer.parseInt(bun));
				System.out.println("Enter # of burgers");
				String bur = sc.nextLine();
				wow.setBurgers(Integer.parseInt(bur));
				System.out.println("Enter # of straws");
				String stra = sc.nextLine();
				wow.setStraws(Integer.parseInt(stra));
				System.out.println("Enter # of cokesyrups");
				String cok = sc.nextLine();
				wow.setCokesyrup(Integer.parseInt(cok));
				System.out.println("Enter # of fries");
				String fr = sc.nextLine();
				wow.setFries(Integer.parseInt(fr));
				System.out.println("Enter # of cups");
				String cup = sc.nextLine();
				wow.setCups(Integer.parseInt(cup));
				System.out.println("Enter # of napkins");
				String nap = sc.nextLine();
				wow.setNapkins(Integer.parseInt(nap));
				//int year = Integer.parseInt(sc.nextLine());
				//wow.setBuns(Integer.parseInt(bun));
				f.addToDatabase(d, wow);
			}
			if(op.equals("15"))
			{
				System.out.println("Enter date MM-dd-yyyy format");
				Scanner sc = new Scanner(System.in);
				String date1 = sc.nextLine();
				String[] dateFinesse = date1.split("-");
				Date d = new Date(Integer.parseInt(dateFinesse[2])-1900, Integer.parseInt(dateFinesse[0])-1, Integer.parseInt(dateFinesse[1]));
				orders wow = new orders();
				System.out.println("Enter Company Name");
				String company = sc.nextLine();
				wow.setCompanyName(company);
				System.out.println("Enter Individual Store Number Ex-#32");
				String indi = sc.nextLine();
				wow.setIndividualRestraurantName(indi);
				System.out.println("Enter # of buns");
				String bun = sc.nextLine();
				wow.setBuns(Integer.parseInt(bun));
				System.out.println("Enter # of burgers");
				String bur = sc.nextLine();
				wow.setBurgers(Integer.parseInt(bur));
				System.out.println("Enter # of straws");
				String stra = sc.nextLine();
				wow.setStraws(Integer.parseInt(stra));
				System.out.println("Enter # of cokesyrups");
				String cok = sc.nextLine();
				wow.setCokesyrup(Integer.parseInt(cok));
				System.out.println("Enter # of fries");
				String fr = sc.nextLine();
				wow.setFries(Integer.parseInt(fr));
				System.out.println("Enter # of cups");
				String cup = sc.nextLine();
				wow.setCups(Integer.parseInt(cup));
				System.out.println("Enter # of napkins");
				String nap = sc.nextLine();
				wow.setNapkins(Integer.parseInt(nap));
				System.out.println("Do you want to print(P) this or add this to a new file(F)?(enter P or F)");
				String dec = sc.nextLine();
				if(dec.equals("F")) {
					System.out.println("Enter your file name");
					String filname = sc.nextLine();
					f.outputFormat(true, filname, wow, d);
				}
				else if(dec.equals("P")) {
					f.outputFormat(false, "nothing", wow, d);
				}
				//int year = Integer.parseInt(sc.nextLine());
				//wow.setBuns(Integer.parseInt(bun));
				f.addToDatabase(d, wow);
			}
			if(op.equals("16")){
				System.out.println("Enter date MM-dd-yyyy format");
				Scanner sc = new Scanner(System.in);
				String date1 = sc.nextLine();
				String[] dateFinesse = date1.split("-");
				Date d = new Date(Integer.parseInt(dateFinesse[2])-1900, Integer.parseInt(dateFinesse[0])-1, Integer.parseInt(dateFinesse[1]));
				orders wow = new orders();
				System.out.println("Enter Company Name");
				String company = sc.nextLine();
				wow.setCompanyName(company);
				System.out.println("Enter Individual Store Number Ex-#32");
				String indi = sc.nextLine();
				wow.setIndividualRestraurantName(indi);
				System.out.println("Enter # of buns");
				String bun = sc.nextLine();
				wow.setBuns(Integer.parseInt(bun));
				System.out.println("Enter # of burgers");
				String bur = sc.nextLine();
				wow.setBurgers(Integer.parseInt(bur));
				System.out.println("Enter # of straws");
				String stra = sc.nextLine();
				wow.setStraws(Integer.parseInt(stra));
				System.out.println("Enter # of cokesyrups");
				String cok = sc.nextLine();
				wow.setCokesyrup(Integer.parseInt(cok));
				System.out.println("Enter # of fries");
				String fr = sc.nextLine();
				wow.setFries(Integer.parseInt(fr));
				System.out.println("Enter # of cups");
				String cup = sc.nextLine();
				wow.setCups(Integer.parseInt(cup));
				System.out.println("Enter # of napkins");
				String nap = sc.nextLine();
				wow.setNapkins(Integer.parseInt(nap));
				System.out.println("Do you want to print(P) this or add this to a new file(F)?(enter P or F)");
				String dec = sc.nextLine();
					System.out.println("Enter your file name");
					String filname = sc.nextLine();
				f.addOrderAndPriceToFile(filname, wow, d);
			}
			if(op.equals("17")){
				System.out.println(f.getAllRestaurant().toString());
			}
			if(op.equals("18")){
				f.resturantMostStores();
			}

		}
	}
}
