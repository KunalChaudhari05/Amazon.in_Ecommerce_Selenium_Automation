package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Homepage {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static WebElement element;
    protected JavascriptExecutor js;

    public void setWebDriver(WebDriver driver) {
        Homepage.driver = driver;
    } // end manual setter setWebDriver

    By navLinks1_home = By.xpath("//a[contains(text(),\"Today's Deals\")]");
    By navLinks2_home = By.xpath("//a[contains(text(),'Customer Service')]");
    By navLinks3_home = By.xpath("//a[contains(text(),'Best Sellers')]");
    By navLinks4_home = By.xpath("//a[contains(text(),'Mobiles')]");
    By navLinks5_home = By.xpath("//header/div[@id='navbar']/div[@id='nav-main']/div[2]/div[1]/div[1]/a[2]");
    By navHamMenu_home = By.id("nav-hamburger-menu");
    By navHamMenuTitle1_home = By.xpath("//div[contains(text(),'digital content and devices')]");
    By navHamMenuTitle2_home = By.xpath("//div[contains(text(),'shop by category')]");
    By navHamMenuTitle3_home = By.xpath("//div[contains(text(),'programs & features')]");
    By navHamMenuTitle4_home = By.xpath("//div[contains(text(),'help & settings')]");
    By navHamMenuClose_home = By.xpath("//body/div[@id='hmenu-container']/div[@id='hmenu-canvas-background']/div[1]");
    By homeLogo = By.cssSelector("#nav-logo-sprites");

    public void viewHomepage() {

        String expectedTitle, actualTitle;

//        expectedTitle = "Amazon.com. Spend less. Smile more.";
        expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        try {
            actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");
            System.out.println("Page title: " + actualTitle);
        } catch (AssertionError e) {
            System.out.println("Test Failed!");
            Assert.fail("Message does not match");
        }

    } // end method viewHomepage()

    public void clickNavLinks() {

        String expectedTitle1, actualTitle1, expectedTitle2, actualTitle2, expectedTitle3, actualTitle3, expectedTitle4, actualTitle4, expectedTitle5, actualTitle5;

        expectedTitle1 = "Today's Deals";
        
        try {
            element = driver.findElement(navLinks1_home);        	
            actualTitle1 = element.getText();
            Assert.assertEquals(actualTitle1, expectedTitle1, "Title does not match!");
            System.out.println("First navigation title: " + actualTitle1);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(expectedTitle1 + " is not available at the moment.");
        }

        expectedTitle2 = "Customer Service";
        try {
            element = driver.findElement(navLinks2_home);
            actualTitle2 = element.getText();
            Assert.assertEquals(actualTitle2, expectedTitle2, "Title does not match!");
            System.out.println("Second navigation title: " + actualTitle2);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(expectedTitle2 + " is not available at the moment.");
        }

        expectedTitle3 = "Best Sellers";
        try {
            element = driver.findElement(navLinks3_home);
            actualTitle3 = element.getText();
            Assert.assertEquals(actualTitle3, expectedTitle3, "Title does not match!");
            System.out.println("Third navigation title: " + actualTitle3);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(expectedTitle3 + " is not available at the moment.");
        }

        expectedTitle4 = "Mobiles";
        try {
            element = driver.findElement(navLinks4_home);
            actualTitle4 = element.getText();
            Assert.assertEquals(actualTitle4, expectedTitle4, "Title does not match!");
            System.out.println("Fourth navigation title: " + actualTitle4);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(expectedTitle4 + " is not available at the moment.");
        }

        expectedTitle5 = "Sell";
        try {
            element = driver.findElement(navLinks5_home);
            actualTitle5 = element.getText();
            Assert.assertEquals(actualTitle5, expectedTitle5, "Title does not match!");
            System.out.println("Fifth navigation title: " + actualTitle5);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(expectedTitle5 + " is not available at the moment.");
        }

    } // end method clickNavLinks()

    public void clickNavHamMenu() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String expectedTitle1, actualTitle1, expectedTitle2, actualTitle2, expectedTitle3, actualTitle3, expectedTitle4, actualTitle4;

        try {
            driver.findElement(navHamMenu_home).click();
            System.out.println("\nHamburger menu is clicked.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Hamburger menu is not available at the moment.");
        }

        Thread.sleep(4000);
        expectedTitle1 = "Digital Content And Devices";
        try {
            element = driver.findElement(navHamMenuTitle1_home);
            actualTitle1 = element.getText();
            Assert.assertEquals(actualTitle1, expectedTitle1, "Title does not match!");
            System.out.println("Navigation menu title: " + actualTitle1);
        } catch (Exception e) {
            System.out.println(expectedTitle1 + " navigation menu title is not available at the moment.");
        }

        expectedTitle2 = "Shop By Category";
        try {
            element = driver.findElement(navHamMenuTitle2_home);
            actualTitle2 = element.getText();
            Assert.assertEquals(actualTitle2, expectedTitle2, "Title does not match!");
            System.out.println("Navigation menu title: " + actualTitle2);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(expectedTitle2 + " navigation menu title is not available at the moment.");
        }

       
        expectedTitle3 = "Programs & Features";
        try {
            element = driver.findElement(navHamMenuTitle3_home);
            actualTitle3 = element.getText();
            Assert.assertEquals(actualTitle3, expectedTitle3, "Title does not match!");
            System.out.println("Navigation menu title: " + actualTitle3);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(expectedTitle3 + " navigation menu title is not available at the moment.");
        }

        expectedTitle4 = "Help & Settings";
        try {
            element = driver.findElement(navHamMenuTitle4_home);
            actualTitle4 = element.getText();
            Assert.assertEquals(actualTitle4, expectedTitle4, "Title does not match!");
            System.out.println("Navigation menu title: " + actualTitle4);
        } catch (Exception e) {
            System.out.println(expectedTitle4 + " navigation menu title is not available at the moment.");
        }

        try {
            element = wait.until(ExpectedConditions.elementToBeClickable(navHamMenuClose_home));
            element.click();
            System.out.println("Hamburger menu close button is clicked.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Hamburger menu close button is not available at the moment.");
        }

    } // end method clickNavHamMenu

    public void clickHome() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(homeLogo));
            element.click();
            System.out.println("Amazon logo is clicked.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nHome logo is not available at the moment.");
        }

    } // end method clickHome()

} // end method Homepage
