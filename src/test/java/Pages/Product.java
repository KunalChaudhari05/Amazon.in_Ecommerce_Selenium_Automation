package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class Product extends Homepage {

    //ShoppingBill shoppingBillObj;
    protected String expectedTitle1, expectedQty, actualTitle1, expectedTitle2, actualTitle2, actualPrice, expectedShippingImportFees, actualShippingImportFees, expectedDeliveryDate, actualDeliveryDate, actualDefaultQty, actualQty, expectedCartSubtotal, actualCartSubtotal, actualCartSubtotalPrice, expectedTitle, actualTitle;
    protected String expectedPrice, expectedDefaultQty;

    By BestSeller = By.xpath("//a[contains(text(),'Best Sellers')]");
//    By prodBestSeller_product = By.xpath("//div[contains(text(),'Lenovo 15.6\" (39.62cm) Slim Everyday Backpack, Mad')]");
    By prodBestSeller_product = By.xpath("//div[contains(text(),'WildHorn Leather Wallet for Men I Ultra Strong Sti')]");
    By price_product = By.xpath("//body/div[@id='a-page']/div[@id='dp']/div[@id='dp-container']/div[@id='ppd']/div[@id='rightCol']/div[@id='desktop_buybox']/div[@id='buybox']/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/span[2]/span[2]");
    By prodDeliveryDate_product = By.xpath("//div[@id='mir-layout-DELIVERY_BLOCK-slot-PRIMARY_DELIVERY_MESSAGE_LARGE']");
    
    public void clickBestSeller() {
    	try {
            driver.findElement(BestSeller).click();
            System.out.println("BestSeller is clicked.");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("BestSeller product is not available at the moment.");
        }
    }
    
    public void clickProductBestSeller() {

        try {
            driver.findElement(prodBestSeller_product).click();
            System.out.println("Best selling product is clicked.");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Best selling product is not available at the moment.");
        }

    } // end method clickProductBestSeller()

    public void viewProductBestSeller() {

        //shoppingBillObj = new ShoppingBill();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Product Page title
        expectedTitle1 = "Buy WildHorn Leather Wallet for Men I Ultra Strong Stitching I 6 Credit Card Slots I 2 Currency Compartments I 1 Coin Pocket at Amazon.in";
        try {
            actualTitle1 = driver.getTitle();
            Assert.assertEquals(actualTitle1, expectedTitle1, "Product page title does not match!");
            System.out.println("Product page title: " + actualTitle1);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(expectedTitle1 + " is not available at the moment.");
        }
    } // end method viewProductBestSeller
    public void productPrice() {
    	wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        String expectedPrice = "285";
        try {
            element = driver.findElement(price_product);
            String actualProductPrice = element.getText();
            Assert.assertEquals(actualProductPrice, expectedPrice,"Price does not match!");
            System.out.println("Product Price: " + actualProductPrice);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void productQty() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    	try {
        	WebElement quantityDropdown = driver.findElement(By.xpath("//select[@id='quantity']"));
            Select select = new Select(quantityDropdown);
            select.selectByIndex(5);
            WebElement selectedQuantityOption = select.getFirstSelectedOption();
            String selectedQuantity = selectedQuantityOption.getText();
            System.out.println("Selected Quantity: " + selectedQuantity);
    	}
    	catch (Exception e) {
            System.out.println("Quantity not changed.");
        } 
    }
    /*
        public void productDeliDate() {
    	 expectedDeliveryDate = "FREE delivery Friday, 15 September on orders dispatched by Amazon over ?499. Details";
         try {
             element = driver.findElement(prodDeliveryDate_product);
             actualDeliveryDate = element.getText();
             Assert.assertEquals(actualDeliveryDate, expectedDeliveryDate, "Delivery date does not match!");
             System.out.println("Delivery date is: " + prodDeliveryDate_product);
         } catch (Exception e) {
             System.out.println("Delivery date has changed.");
         } 
        }
        */
    } // end method Product
