package tasktestmavensource;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Fav extends BasePage {
	
	By addFavButtonBy;
	By deleteButtonBy;
	
	String favURL = "https://www.n11.com/hesabim/favorilerim";
	public static String savedProduct;
	String productInFavListName;
	

	public Fav(WebDriver driver) {
		super(driver);
	}

	public void addFav() {
		addFavButtonBy = By.xpath("//li[3]/div/div[2]/span");
		click(addFavButtonBy);
		savedProduct = driver.findElement(By.xpath("//li[3]/div/div/a/h3")).getText();
		System.out.println("Item added to favs list.");
		System.out.println(savedProduct);
	}

	public List<WebElement> findListByXpad(String name) {
		List<WebElement> Elements = driver.findElements(By.xpath(name));
		return Elements;
	}

	public void goToFavPage() {
		System.out.println("Now going to favourites list page.");
		driver.get(favURL);
	}

	
	public void deleteButton() {
		deleteButtonBy = By.xpath("//div[3]/div/div[2]/ul/li/div/div[3]/span");
		click(deleteButtonBy);
	}
	
}
