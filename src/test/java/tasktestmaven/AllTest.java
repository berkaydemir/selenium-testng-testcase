package tasktestmaven;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tasktestmavensource.Fav;
import tasktestmavensource.HomePage;
import tasktestmavensource.Search;

public class AllTest extends BaseTest {
	WebElement element = null;

	@Test(priority = 0)
	public void invalidLoginTest_InvalidUserNameInvalidPassword() {
		// *************PAGE INSTANTIATIONS*************
		HomePage homePage = new HomePage(driver);

		// *************PAGE METHODS********************
		homePage.goToN11().goToLoginPage().loginToN11("qwert12345@gmail.com", "12345")
				.verifyLoginPassword(("E-posta adresiniz veya þifreniz hatalý"))
				.verifyLoginPassword(("E-posta adresiniz veya þifreniz hatalý"));

	}

	@Test(priority = 1)
	public void invalidLoginTest_EmptyUserEmptyPassword() {
		// *************PAGE INSTANTIATIONS*************
		HomePage homePage = new HomePage(driver);

		// *************PAGE METHODS********************
		homePage.goToN11().goToLoginPage().loginToN11("", "").verifyLoginUserName("Lütfen e-posta adresinizi girin.")
				.verifyLoginPassword("Bu alanýn doldurulmasý zorunludur.");
	}

	@Test(priority = 2)
	public void invalidSearchItem() {
		Search searchPage = new Search(driver);
		searchPage.searchItem("samsung");
		searchPage.goToSecondPage();
	}

	@Test(priority = 3)
	public void addFavItem() {
		Fav newFavItem = new Fav(driver);
		newFavItem.addFav();
//		newFavItem.saveProduct();
	}

	@Test(priority = 4)
	public void goToFavPage() {
		Fav newFavItem = new Fav(driver);
		newFavItem.goToFavPage();
	}

	@Test(priority = 5)
	public void clickedFavouriteConfirm() {
		int willDeleteFavorite = 0;
		Fav newFavItem = new Fav(driver);
		int favoriesCount = 0;
		List<WebElement> productTitles = newFavItem.findListByXpad("//*[@class='productTitle']/p/a");
		for (WebElement productTitle : productTitles) {
			favoriesCount += 1;
			String watchesProduct = productTitle.getText();
			if (watchesProduct == Fav.savedProduct) {
				System.out.println("Confirmed product in the favourite list .Product Title: " + watchesProduct + "\n");
				willDeleteFavorite = favoriesCount;
				newFavItem.deleteButton();
				System.out.println("Item deleted");
				Assert.assertTrue(watchesProduct.equals(Fav.savedProduct));
				newFavItem.deleteButton();
				System.out.println("Deleted Item: "+watchesProduct);
			}
		}
	}
}
