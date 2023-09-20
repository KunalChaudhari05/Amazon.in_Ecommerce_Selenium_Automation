package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchAndSearchResults extends Homepage {

    By searchField_home = By.id("twotabsearchtextbox");
    By searchBtn_home = By.id("nav-search-submit-button");
    By list_searchResults = By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']");
    By list_viewResults = By.className("s-line-clamp-2");
    By list_countResults = By.xpath("/html[1]/body[1]/div[1]/div[2]/span[1]/div[1]/span[1]/h1[1]/div[1]/div[1]/div[1]/div[1]/span[1]");
    By list_searchTerm = By.xpath("/html[1]/body[1]/div[1]/div[2]/span[1]/div[1]/span[1]/h1[1]/div[1]/div[1]/div[1]/div[1]/span[3]");

    public void enterSearchFieldHome(String text) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        element = driver.findElement(searchField_home);
        element.sendKeys(text);

        element = driver.findElement(searchBtn_home);
        element.click();

        element = wait.until(ExpectedConditions.visibilityOfElementLocated(list_searchResults));
        String searchList = element.getText();
        System.out.println("\nFirst Search Result: " + searchList);

    } // end method enterSearchFieldHome

    public void selectSingleCheckBox(String displayText) throws InterruptedException {
        Thread.sleep(4000);
        WebElement CheckBox = driver.findElement(By.xpath("//li[@aria-label='"+displayText+"']//i"));
        boolean b=CheckBox.isSelected();
        System.out.println("Checkbox selected : "+b);
        if(!b) {
        	CheckBox.click();
        }
        Thread.sleep(4000);
        }

    public void testMultipleCheckbox(List<String> MuldisplayTexts) throws InterruptedException
	{
    	    for (int i = 0; i < MuldisplayTexts.size(); i++) {
    	    	Thread.sleep(1000);
    	    	
    	    	driver.findElement(By.xpath("//li[@aria-label='"+MuldisplayTexts.get(i)+"']//i")).click();     
    	    }
	}
	
    public void clearFields() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        element = driver.findElement(searchField_home);
        element.clear();

    } // end method clearFields()
    
    
} // end method SearchAndSearchResults
