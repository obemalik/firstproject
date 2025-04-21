package sumayalesson1;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//this is myfirstproject in githup

public class mytest {

	WebDriver driver = new EdgeDriver();
	String THEWEBSITE = "https://www.saucedemo.com/";

	String UserName = "standard_user";

	String PassWord = "secret_sauce";

	@BeforeTest
	public void mySetup() {
		driver.manage().window().maximize();

		driver.get(THEWEBSITE);

	}

	@Test(priority = 1)
	public void login() throws InterruptedException {

		WebElement UserNameInput = driver.findElement(By.id("user-name"));

		WebElement PasswordInput = driver.findElement(By.id("password"));

		WebElement LoginButton = driver.findElement(By.id("login-button"));

		UserNameInput.sendKeys(UserName);
		PasswordInput.sendKeys(PassWord);
		LoginButton.click();   

	}

	 @Test(priority = 2)
	    public void addAllItemsFromTheCart() throws InterruptedException {
		 List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		 
		 for (int i = 0; i < AddToCartButtons.size(); i++) {
		     AddToCartButtons.get(i).click();
		     
		        Thread.sleep(2000);
		 }
		 
	    }

	 @Test (priority = 3)
	 public void RemoveAllItems() throws InterruptedException {
		 List<WebElement> RemoveButtons = driver.findElements(By.className("btn_secondary"));
		 for (int i = 0; i <RemoveButtons .size(); i++) {
			 RemoveButtons.get(i).click();
		     
			 Thread.sleep(2000);	 }
	 }
	 
	 @Test(priority = 4)
	 public void Task () {
		 List<WebElement>ItemsNames = driver.findElements(By.className("inventory_details_name large_size"));
String itemName = 	ItemsNames.get(0).getText();
for(int i = 0 ;i<ItemsNames.size();i++) {

	
	System.out.println(itemName.charAt(i));
	

	
}	 
	 }
	    @Test(enabled = false)
	    public void removeItemFromTheCart() {
	        WebElement BackpackRemoveButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
	        BackpackRemoveButton.click();
	    }

	    @Test(priority = 5,enabled = false)
	    public void logout() throws InterruptedException {
	        WebElement BurgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
	        BurgerMenu.click();
	        Thread.sleep(1000);

	        WebElement logOutButton = driver.findElement(By.id("logout_sidebar_link"));
	        logOutButton.click();
	        Thread.sleep(1000);

	        WebElement Mainlogo = driver.findElement(By.className("login_logo"));
	        System.out.println(Mainlogo.getText());

	        WebElement UserNames = driver.findElement(By.id("login_credentials"));
	        System.out.println(UserNames.getText());
	    }

//	    @AfterTest
	    public void myAfterTest() {
	        driver.quit();
	    }
	}
