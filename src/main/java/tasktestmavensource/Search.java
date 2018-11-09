package tasktestmavensource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Search extends HomePage {
	
	public Search(WebDriver driver) {
		super(driver);
	}
	By searchDataBy = By.id("searchData");
	By searchButtonBy = By.className("searchBtn");
	By pageTwoButton = By.xpath("//*[@id=\"contentListing\"]/div/div/div[2]/div[3]/a[2]");
	public void searchItem(String findItem) {
		//Enter item name
		writeText(searchDataBy,findItem);
		//Click on search button
		click(searchButtonBy);
		//send message;
		System.out.println("Searching item: "+findItem);
	}
	public void goToSecondPage() {
		System.out.println("Now going to second page...");
		click(pageTwoButton);
	}

}
