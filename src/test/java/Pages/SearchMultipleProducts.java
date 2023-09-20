package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.Set;

public class SearchMultipleProducts extends Homepage {

    By searchField_home = By.id("twotabsearchtextbox");
    By searchBtn_home = By.id("nav-search-submit-button");
     
    //for .in
    By laptopAccLink_searchResults = By.xpath("//span[contains(text(),'SOUNDANCE Laptop Stand, Aluminum Computer Riser, E')]");
    By title_product = By.xpath("//span[@id='productTitle']");
    By price_product =By.xpath("//body/div[@id='a-page']/div[@id='dp']/div[@id='dp-container']/div[@id='ppd']/div[@id='rightCol']/div[@id='desktop_buybox']/div[@id='buybox']/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/span[2]/span[2]");
    //for .in
	By HeadsetLink_product = By.xpath("//span[contains(text(),'boAt Rockerz 450 Bluetooth On Ear Headphones with Mic')]");
	By HeadsetTitle_product = By.xpath("//span[@id='productTitle']");
	By HeadsetBrand_product = By.xpath("//a[@id='bylineInfo']");
    
  //for .in
    By wifiRouterLink_searchResults = By.xpath("//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/h2[1]/a[1]/span[1]");
    By wifiRouterPrice_product =By.xpath("//body/div[@id='a-page']/div[@id='dp']/div[@id='dp-container']/div[@id='ppd']/div[@id='rightCol']/div[@id='desktop_buybox']/div[@id='buybox']/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/span[2]/span[2]");
    
    By wallChargerTitleLink_product = By.xpath("//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/h2[1]/a[1]/span[1]");
    By wallChargerTitle_product = By.xpath("//span[@id='productTitle']");
    By wallChargerDDate_product = By.xpath("//div[@id='mir-layout-DELIVERY_BLOCK-slot-PRIMARY_DELIVERY_MESSAGE_LARGE']");

    public void searchForItems(String text){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try{
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(searchField_home));
            element.clear();
            element.sendKeys(text);

            element = driver.findElement(searchBtn_home);
            element.click();
            System.out.println("Search for item: " + text);
        }catch (Exception e){
            e.printStackTrace();
        }

    } // end searchForLaptopAccessories()


    public void viewLaptopAccessories(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try{
        	String parentWindowHandle = driver.getWindowHandle();
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(laptopAccLink_searchResults));
            element.click();
            System.out.println("Laptop_Accessories link is clicked.");           
            Set<String> windowHandles = driver.getWindowHandles();
            for (String windowHandle : windowHandles) {
                // Switch to the new window
                driver.switchTo().window(windowHandle);
                // Perform actions in the new window        
                if (!windowHandle.equals(parentWindowHandle)) {

                    System.out.println("Title of the new window: " + driver.getTitle());
                    
                    //Price
                    wait = new WebDriverWait(driver, Duration.ofSeconds(20));

                    String expectedPrice = "10,454";
                    try {
                        element = driver.findElement(price_product);
                        String actualProductPrice = element.getText();
                        Assert.assertEquals(actualProductPrice, expectedPrice,"Price does not match!");
                        System.out.println("Product Price: " + actualProductPrice);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    
                    WebElement quantityDropdown = driver.findElement(By.xpath("//select[@id='quantity']")); // Update the ID as needed
                    // Create a Select object for the dropdown
                    Select select = new Select(quantityDropdown);
                    select.selectByIndex(5);

                    // Verify the selected quantity (optional)
                    WebElement selectedQuantityOption = select.getFirstSelectedOption();
                    String selectedQuantity = selectedQuantityOption.getText();
                    System.out.println("Selected Quantity: " + selectedQuantity);

                    driver.close();
                }    
            }
            driver.switchTo().window(windowHandles.iterator().next());
            System.out.println("Title of the parent window: " + driver.getTitle());
            
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Laptop_Accessories link is not available at the moment.");
        }
    }


    public void viewHeadset(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
        	String parentWindowHandle = driver.getWindowHandle();
        	element = wait.until(ExpectedConditions.visibilityOfElementLocated(HeadsetLink_product));
            element.click();
            System.out.println("Headset Link is clicked.");           
            Set<String> windowHandles = driver.getWindowHandles();
        	
            for (String windowHandle : windowHandles) {
                // Switch to the new window
                driver.switchTo().window(windowHandle);
                // Perform actions in the new window        
                if (!windowHandle.equals(parentWindowHandle)) {

                    System.out.println("Title of the new window: " + driver.getTitle());

                    try{
                        element = wait.until(ExpectedConditions.visibilityOfElementLocated(HeadsetBrand_product));
                        String actualUSBHeadsetBrand = element.getText();
                        System.out.println("Features: " + actualUSBHeadsetBrand);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    driver.close();
                }    
            }
            driver.switchTo().window(windowHandles.iterator().next());
            System.out.println("Title of the parent window: " + driver.getTitle());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
    }

    public void viewWifiRouter(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try{
        	String parentWindowHandle = driver.getWindowHandle();
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(wifiRouterLink_searchResults));
            element.click();
            System.out.println("Wifi Router link is clicked.");           
            Set<String> windowHandles = driver.getWindowHandles();
            for (String windowHandle : windowHandles) {
                // Switch to the new window
                driver.switchTo().window(windowHandle);
                // Perform actions in the new window      
                if (!windowHandle.equals(parentWindowHandle)) {

                    System.out.println("Title of the new window: " + driver.getTitle());
                    
                    //price
                    String expectedPrice = "2,599";
                    try {
                        element = driver.findElement(wifiRouterPrice_product);
                        String actualProductPrice = element.getText();
                        Assert.assertEquals(actualProductPrice, expectedPrice,"Price does not match!");
                        System.out.println("Product Price: " + actualProductPrice);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    
                    WebElement quantityDropdown = driver.findElement(By.xpath("//select[@id='quantity']")); // Update the ID as needed
                    // Create a Select object for the dropdown
                    Select select = new Select(quantityDropdown);
                    select.selectByIndex(2);
                    // Verify the selected quantity (optional)
                    WebElement selectedQuantityOption = select.getFirstSelectedOption();
                    String selectedQuantity = selectedQuantityOption.getText();
                    System.out.println("Selected Quantity: " + selectedQuantity);
                    driver.close();
                }    
            }
            driver.switchTo().window(windowHandles.iterator().next());
            System.out.println("Title of the parent window: " + driver.getTitle());

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Wifi Router link is not available at the moment.");
        }
    }

    public void viewWallCharger(){
    	
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try{
        	String parentWindowHandle = driver.getWindowHandle();
        	element = wait.until(ExpectedConditions.visibilityOfElementLocated(wallChargerTitleLink_product));
            element.click();
            System.out.println("WallCharger Link is clicked.");           
            Set<String> windowHandles = driver.getWindowHandles();
        	
            for (String windowHandle : windowHandles) {
                // Switch to the new window
                driver.switchTo().window(windowHandle);
                // Perform actions in the new window        
                if (!windowHandle.equals(parentWindowHandle)) {

                    System.out.println("Title of the new window: " + driver.getTitle());
                    wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                    wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                    try{
                        element = wait.until(ExpectedConditions.visibilityOfElementLocated(wallChargerDDate_product));
                        String actualWallChargerDate = element.getText();
                        System.out.println("Wall Charger Delivery Date: " + actualWallChargerDate);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    driver.close();
                }    
            }
            driver.switchTo().window(windowHandles.iterator().next());
            System.out.println("Title of the parent window: " + driver.getTitle());                    

        }catch (Exception e){
            e.printStackTrace();
        }        
    }
} // end SearchAndShopMultipleProducts
