package FoodSuplier;

public class orders {
	String companyName;
	String IndividualRestraurantName;
	int burgers;
	int buns;
	int cups;
	int straws;
	int cokesyrup;
	int fries;
	int napkins;
	public orders(){
		IndividualRestraurantName = "";
		companyName = "";
		burgers = 0;
		buns = 0;
		cups = 0;
		straws = 0;
		cokesyrup = 0;
		fries = 0;
		napkins = 0;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getIndividualRestraurantName() {
		return IndividualRestraurantName;
	}
	public void setIndividualRestraurantName(String individualRestraurantName) {
		IndividualRestraurantName = individualRestraurantName;
	}
	public int getBurgers() {
		return burgers;
	}
	public void setBurgers(int burgers) {
		this.burgers = burgers;
	}
	public int getBuns() {
		return buns;
	}
	public void setBuns(int buns) {
		this.buns = buns;
	}
	public int getCups() {
		return cups;
	}
	public void setCups(int cups) {
		this.cups = cups;
	}
	public int getStraws() {
		return straws;
	}
	public void setStraws(int straws) {
		this.straws = straws;
	}
	public int getCokesyrup() {
		return cokesyrup;
	}
	public void setCokesyrup(int cokesyrup) {
		this.cokesyrup = cokesyrup;
	}
	public int getFries() {
		return fries;
	}
	public void setFries(int fries) {
		this.fries = fries;
	}
	public int getNapkins() {
		return napkins;
	}
	public void setNapkins(int napkins) {
		this.napkins = napkins;
	}
	public int get(String item) {
		switch(item) {
		case("burgers"):
			return this.burgers;
		case("buns"):
			return this.buns;
		case("napkins"):
			return this.napkins;
		case("straws"):
			return this.straws;
		case("cups"):
			return this.cups;
		case("fries"):
			return this.fries;
		case("cokesyrup"):
			return this.cokesyrup;
		}
			return -1;
	}
	public String fileFormat() {
		String result = "";
		result += this.companyName + this.IndividualRestraurantName;
		if(this.cups!=0)
			result+=" cups-" + this.cups;
			else if(this.buns!=0)
				result+=" buns-" + this.buns;
				else if(this.burgers!=0)
					result+=" burgers-" + this.burgers;
					else if(this.straws!=0)
						result+=" straws-" + this.straws;
						else if(this.cokesyrup!=0)
							result+=" cokesyrup-" + this.cokesyrup;
							else if(this.fries!=0)
								result+=" fries-" + this.fries;
								else if(this.napkins!=0)
									result+=" napkins-" + this.napkins;
		return result;
	}
	public String toString() {
		return "Company Name: " + this.companyName +  " IndividualRestaurantName: " + this.IndividualRestraurantName +  " Napkins: " + this.napkins +  " straws: " + this.straws +  " cups: " + this.cups +  " coke syrup: " + this.cokesyrup +  " fries: " + this.fries +  " buns: " + this.buns + " burgers: " + this.burgers;
	}

}

