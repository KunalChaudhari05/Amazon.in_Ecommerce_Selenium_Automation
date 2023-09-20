package testcases;

/*
 ****************************************

 @author Kunal Chaudhari
* @date 09 September 2023
* @project Amazon_Automation (ECommerce Selenium Java)
* ****************************************
*/

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import Pages.Homepage;
import Pages.Product;
import Pages.SearchAndSearchResults;
import Pages.SearchMultipleProducts;


public class ECommerceTestCases {

    // tools
    private static WebDriver driver;

    // pages
    protected static Homepage homepageObj;
    protected static Product productObj;
    protected static SearchAndSearchResults searchAndSearchResultsObj;
    protected static SearchMultipleProducts searchAndShopMultipleProductsObj;

    
    @BeforeTest
    public void setupTest() {
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 1);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.setAcceptInsecureCerts(true);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        String appURL = "https://www.amazon.in/";
        driver.get(appURL);    
        driver.manage().deleteAllCookies();
        
        homepageObj = new Homepage();
        homepageObj.setWebDriver(driver);

        productObj = new Product();
        productObj.setWebDriver(driver);

        searchAndSearchResultsObj = new SearchAndSearchResults();
        searchAndSearchResultsObj.setWebDriver(driver);

        searchAndShopMultipleProductsObj = new SearchMultipleProducts();
        searchAndShopMultipleProductsObj.setWebDriver(driver);

    } // end method setupTest()

    @Test(priority = 1)
    public void testHomepage() throws IOException, InterruptedException {

        homepageObj.viewHomepage();
        homepageObj.clickNavLinks();
        homepageObj.clickNavHamMenu();
        Thread.sleep(4000);
        
        TakesScreenshot Ts = (TakesScreenshot)driver;
        File SrcFIle = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File DectFile = new File("./screenshort/Homepage.png");
        FileUtils.copyFile(SrcFIle, DectFile);
       	System.out.println("Screenshot saved to: " + DectFile);
    } // end method testHomepage

    @Test(priority = 2)
    public void testSearchAndSearchResults() throws InterruptedException, IOException {

        searchAndSearchResultsObj.enterSearchFieldHome("Laptop");
        searchAndSearchResultsObj.selectSingleCheckBox("Lenovo");
//        List<String> MuldisplayTexts = Arrays.asList("Acer", "Lenovo", "Apple");
//        searchAndSearchResultsObj.testMultipleCheckbox(MuldisplayTexts);
       
        TakesScreenshot Ts = (TakesScreenshot)driver;
        File SrcFIle = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File DectFile = new File("./screenshort/LaptopSearch.png");
        FileUtils.copyFile(SrcFIle, DectFile);
       	System.out.println("Screenshot saved to: " + DectFile);
       	
        searchAndSearchResultsObj.clearFields();
        
        Thread.sleep(3000);
        searchAndSearchResultsObj.enterSearchFieldHome("Mouse");
        searchAndSearchResultsObj.selectSingleCheckBox("Dell");
        
        searchAndSearchResultsObj.clearFields();
        Thread.sleep(3000);

        searchAndSearchResultsObj.enterSearchFieldHome("Keyboard");
        searchAndSearchResultsObj.clearFields();
        Thread.sleep(3000);

        searchAndSearchResultsObj.enterSearchFieldHome("PC");
//        List<String> MuldisplayTexts = Arrays.asList("Lenovo", "Dell", "ZEBRONICS");
//        searchAndSearchResultsObj.testMultipleCheckbox(MuldisplayTexts);
        searchAndSearchResultsObj.clearFields();
        Thread.sleep(3000);

        searchAndSearchResultsObj.enterSearchFieldHome("Desktop Processor");
        searchAndSearchResultsObj.clearFields();
        Thread.sleep(3000);

        searchAndSearchResultsObj.enterSearchFieldHome("Motherboard");
        searchAndSearchResultsObj.clearFields();
        Thread.sleep(3000);

        searchAndSearchResultsObj.enterSearchFieldHome("Ram");
        searchAndSearchResultsObj.clearFields();
        Thread.sleep(3000);

        searchAndSearchResultsObj.enterSearchFieldHome("Computer Server");
        searchAndSearchResultsObj.clearFields();
        homepageObj.clickHome();

    } // end method testSearchAndSearchResults()

    @Test(priority = 3)
    public void testSearchAndShopMultipleProducts() throws IOException {
    	
    	homepageObj.clickHome();

        searchAndShopMultipleProductsObj.searchForItems("Soundance Laptop Stand, Aluminum Computer Riser, Ergonomic Laptops Elevator for Desk, Metal Holder Compatible with 10 to 15.6 Inches Notebook Computer, Silver");
        searchAndShopMultipleProductsObj.viewLaptopAccessories();

        homepageObj.clickHome();
        searchAndShopMultipleProductsObj.searchForItems("boAt Rockerz 450 Bluetooth On Ear Headphones with Mic, Upto 15 Hours Playback, 40MM Drivers, Padded Ear Cushions, Integrated Controls and Dual Modes(Luscious Black)");
        searchAndShopMultipleProductsObj.viewHeadset();
  
        homepageObj.clickHome();

        searchAndShopMultipleProductsObj.searchForItems("TP-Link Archer AC1200 Archer C6 Wi-Fi Speed Up to 867 Mbps/5 GHz + 400Mbps/2.4 GHz, 5 Gigabit Ports, 4 External Antennas, MU-MIMO, Dual Band, WiFi Coverage with Access Point Mode, Black");
        searchAndShopMultipleProductsObj.viewWifiRouter();
        
        TakesScreenshot Ts = (TakesScreenshot)driver;
        File SrcFIle = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File DectFile = new File("./screenshort/WifiSearch.png");
        FileUtils.copyFile(SrcFIle, DectFile);
       	System.out.println("Screenshot saved to: " + DectFile);

        homepageObj.clickHome();
        searchAndShopMultipleProductsObj.searchForItems("Desktop Power Strip with 3 Outlet 4 USB Ports 4.5A, Flat Plug and 5 ft Long Braided Extension Cords for Cruise Ship Travel Home Office, ETL Listed");
        searchAndShopMultipleProductsObj.viewWallCharger();
    } // end testSearchAndShopMultipleProducts()

    @Test(priority = 4)
    public void testProductPage() throws InterruptedException, IOException {

    	productObj.clickBestSeller();
        productObj.clickProductBestSeller();
        productObj.viewProductBestSeller();
        productObj.productPrice();
        productObj.productQty();
        
        Thread.sleep(4000);
        TakesScreenshot Ts = (TakesScreenshot)driver;
        File SrcFIle = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File DectFile = new File("./screenshort/ProductOperation.png");
        FileUtils.copyFile(SrcFIle, DectFile);
       	System.out.println("Screenshot saved to: " + DectFile);
    } // end method testProductPage()

    @AfterTest
    public void quitBrowser() {

        driver.close();
        driver.quit();
    } // end method quitBrowser()
} // end method ECommerceTestCases
