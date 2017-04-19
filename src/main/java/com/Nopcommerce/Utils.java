package com.Nopcommerce;

import com.google.common.collect.Ordering;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 4/8/2017.
 */
public class Utils extends BasePage {


    /**
     * Created by user on 4/2/2017.
     */


    //send / Type Text to field like name ,username or passward
    public static void typeText(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);

    }
   // public static   totalPriceOfProduct
    //click on any element
    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    //method to sleeep at any point in webpage
    public static void sleep(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //select dropdwon by visible text/resuable methods
    public static void selectText(By by, String text) {
        new Select(driver.findElement(by)).selectByVisibleText(text);

    }

    //For Dropdown Select by Value
    public static void selectValue(By by, String value) {
        Select select = new Select(driver.findElement(by));//  Named objected created object
        select.selectByValue(value);
    }

    //For DropDown Select by index
    public static void selectIndex(By by, int indexnumber) {
        Select select;  //created object
        new Select(driver.findElement(by)).selectByIndex(indexnumber); //Nameless object
    }
    // For Open URL for any Website

    public static void getLink(String url) {

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    // Close Browser Window
    public static void close() {
        driver.close();

    }

    public static void quit() {
        driver.quit();

    }

    // Explict Wait Methods
    //Wait Untill Element to be presents
    public static void elementToBeP88resent(By by, int second) {
        WebDriverWait wait = new WebDriverWait(driver, second);//named object of wait
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    // Wait Untill Element to be Clickable


    public static void elementToBeClickable(By by, int second) {
        WebDriverWait wait = new WebDriverWait(driver, second);//named object of wait
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    // Wait Untill Element to be Visible
    public static void elementToBeVisible(By by, int second) {
        WebDriverWait wait = new WebDriverWait(driver, second);//named object of wait
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //Wait Untill Element to be Selected
    public static void elementToBeSlecected(By by, int second) {
        WebDriverWait wait = new WebDriverWait(driver, second);
        wait.until(ExpectedConditions.elementToBeSelected(by));
    }

    //Wait Untill to be disable (invisibility of Element Located)
    public static void invisibilityOfElementLocated(By by, int second) {
        WebDriverWait wait = new WebDriverWait(driver, second);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    //Wait Untill to be disable (invisibility of Element with Text)
    public static void invisibilityOfElementWithText(By by, String text, int second) {
        WebDriverWait wait = new WebDriverWait(driver, second);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(by, text));
    }

    // Fluent Wait


    // To Get Text from Any Element
    public static String getText(By by) {
        String text = driver.findElement(by).getText();
        return text;
    }
    //Drop down selection by Attribute if select class is not availabl in firepath console

    public static void dropDowmSelectionByAttribute(By by, String attributeName, String dropDownText) {
        java.util.List<WebElement> size_menu = driver.findElements(by);
        for (WebElement element : size_menu) {
            String innerText = element.getAttribute(attributeName);
            if (innerText.contentEquals(dropDownText)) {
                element.click();
                break;
            }
        }
    }


    //Date Stamp Method
    public static String dateStamp() {
        DateFormat dateFormat = new SimpleDateFormat("8ddmmhhss");
        Date date = new Date();
        String d = dateFormat.format(date);
        return d;
    }

    //ScreenShot Method
    // Browser Screen Shot
    public static void browserScreenShot(String filePath) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scr1, new File(filePath + "\\photo" + dateStamp() + ".jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Print Screen ScreenShot
    public static void pringScreen(String filePath)

    {
        try {
            Robot robot = new Robot();
            BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(screenShot, "jpg", new File(filePath + "\\photo)" + dateStamp() + ".jpg"));
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Random Number Method
    public static int randomNumber(int range) {
        Random random = new Random();
        int a = random.nextInt(range);
        return a;
    }


    //Reusable boolean method for verifying if element is present
    public static boolean isElementPresent(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }

    //Resauble method for Waiting for Element to be Present
    public static void waitElementPresent(By by) {
        int counter = 0;
        while (counter <= 10) {
            try {
                if (driver.findElement(by).isDisplayed()) {
                    counter++;
                    System.out.println("waiting for a Second.......");
                    sleep(1);

                } else {
                    return;
                }
            } catch (Exception e) {
                return;
            }
        }

    }

    //Resauble method to scrollPage
    public static void scrillPage(int x, int y) {

        ((JavascriptExecutor) driver).executeScript("scroll(x,y)");
    }

    // Mouse hover any element
    public static void mouseHover(By by) {
        Actions actions = new Actions(driver);
        WebElement mouse = driver.findElement(by);
        actions.moveToElement(mouse).build().perform();
    }

    // Price Conversion Method
    public static double priceConversion(By by) {
        // To convert price into integer from string
        String price = getText(by);
        StringBuilder value = new StringBuilder();
        StringBuilder currencySymbol = new StringBuilder();
        for (char a : price.toCharArray()) {
            if (Character.isDigit(a) || a == '.') {
                value.append(a);
            } else {
                currencySymbol.append(a);
            }
        }
        String a1 = value.toString();
        double result = Double.parseDouble(a1);
        return result;
    }


    // To enter Locator and print the text on that locator
    public static String printTextOfLocator(By by) {
        WebElement element = driver.findElement(by);
        String text = element.getAttribute("innerText");
        return text;
    }

    // Reusable boolean method for verifying is element present


    // Reusable method for waiting for element to be Present
    public static void waitUntilElementToBePresent(By by) {
        int counter = 0;
        while (counter <= 10) {
            try {
                if (driver.findElement(by).isDisplayed()) {
                    counter++;
                    System.out.println("Waitting for a Second.....");
                    sleep(1);
                } else {
                    return;
                }
            } catch (Exception e) {
                return;
            }
        }
    }

    // Assert by getting text from web location
    public static void assertByGetText(By by, String expectedText, String errorMessage) {
        Assert.assertEquals(getText(by), expectedText, errorMessage);
    }

    // Assertion by getting attribute value from web location
    public static void assertByGetAttribute(By by, String attributeValue, String expectedText, String errorMessege)
    {
        Assert.assertEquals(assertByGetAttribute(by, attributeValue),expectedText, errorMessege);
    }

    private static boolean assertByGetAttribute(By by, String attributeValue) {

    }


    // Assertion by String variables
    public static void assertByStringVariable(String expectedText, String actualText, String errorMessage) {
        Assert.assertEquals(expectedText, actualText, errorMessage);
    }

    // Soft Assert Method
    public static void softAssert(By by, String expectedText, String message) {
        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(getText(by), expectedText, message);
        assertion.assertAll();
    }

    public static void softAssertForIntValue(double actual, double expected, String message) {
        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(actual, expected, message);
        assertion.assertAll();
    }

    // Product sortBy Position in any page
    public static void sortByPosition(String position) {
        if (position.equalsIgnoreCase("Price: Low to High")) {
            selectText(By.id("products-orderby"), "Price: Low to High");
        } else if (position.equalsIgnoreCase("Name: A to Z")) {
            Assert.assertEquals(By.id("products-orderby"), "Name: A to Z");
        } else if (position.equalsIgnoreCase("Name: Z to A")) {
            selectText(By.id("products-orderby"), "Name: Z to A");
        } else if (position.equalsIgnoreCase("Created on")) {
            selectText(By.id("products-orderby"), "Created on");
        }
    }

    // Method to set number of product to Display per Page
    public static void displayBy(int a) {
        if (a == 3) {
            selectText(By.id("products-pagesize"), "3");
        } else if (a == 9) {
            selectText(By.id("products-pagesize"), "9");
        } else if (a == 6) {
            selectText(By.id("products-pagesize"), "6");
        }
    }


    // Method for Assert that products are display per page
    //  public static boolean assertDisplayPerPage(By by,int perPage)
    //{   boolean isDisplay=false;
    //
    //    List<WebElement> productsNames_WebElement = driver.findElements(by);
    //  List<String> product_names = new ArrayList<String>();
//
    //   for (WebElement e : productsNames_WebElement) {
    //     String s = e.getText();
    //   product_names.add(s);

    //if (perPage==product_names.size())

    //  isDisplay=true;

    //return isDisplay ;


    //Reusable method for alert accept
    //  public void alertAccept() {
    //     Alert alert = driver.switchTo().alert();
    //   alert.accept();


    // Method for Assert True for boolean condition
    public void assertTrueContains(String locator, String type, String contains, String message) {
        type = type.toLowerCase();
        if (type.equals("id")) {
            Assert.assertTrue(getText(By.id(locator)).contains(contains), message);
        } else if (type.equals("xpath")) {
            Assert.assertTrue(getText(By.xpath(locator)).contains(contains), message);
        } else if (type.equals("css")) {
            Assert.assertTrue(getText(By.cssSelector(locator)).contains(contains), message);
        } else if (type.equals("linktext")) {
            Assert.assertTrue(getText(By.linkText(locator)).contains(contains), message);
        } else if (type.equals("partiallinktext")) {
            Assert.assertTrue(getText(By.partialLinkText(locator)).contains(contains), message);
        } else if (type.equals("tag")) {
            Assert.assertTrue(getText(By.tagName(locator)).contains(contains), message);
        } else if (type.equals("name")) {
            Assert.assertTrue(getText(By.name(locator)).contains(contains), message);
        } else if (type.equals("class")) {
            Assert.assertTrue(getText(By.className(locator)).contains(contains), message);
        } else {
            System.out.println("Locator type not supported");
        }

    }

    // Assert True for IsSelected Method
    public static void assertTrueIsSelected(By by, String message) {
        Assert.assertTrue(driver.findElement(by).isSelected(), message);
    }

    // Method for Refresh the web Page
    public static void refresh() {
        driver.navigate().refresh();
    }

}




