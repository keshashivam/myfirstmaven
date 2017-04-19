package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by user on 4/17/2017.
 */
public class Cellphone extends Utils
{
    //Buying Cell phone from Cell phone page
    public static void cellPhone()
    {
        double price1, price2, price3;
        // Take price of HTC One M8 Android L 5.0 Lollipop product
        price1 = priceConversion(By.xpath("//div[@class=\"product-item\"]/div[2]/div[3]/div/span"));

        // And Add Above Product to Add to Cart
        clickOnElement(By.xpath("//div[@class=\"master-column-wrapper\"]/div[2]/div/div[2]/div[3]/div/div/div/div[2]/div[3]/div[2]/input"));
        Assert.assertEquals("The product has been added to your shopping cart", getText(By.xpath("//div[@id=\"bar-notification\"]/p")));
        clickOnElement(By.xpath("//span[@class=\"close\"]"));

        // Refresh Page
        driver.navigate().refresh();
        sleep(2);

        // Take Price of HTC One Mini Blue product
        price2 = priceConversion(By.xpath("//div[2]/div/div[2]/div[3]/div/span"));

        // Add Above Product to Add to Cart
        clickOnElement(By.xpath("//div[@class=\"master-column-wrapper\"]/div[2]/div/div[2]/div[3]/div/div[2]/div/div[2]/div[3]/div[2]/input"));
        Assert.assertEquals("The product has been added to your shopping cart", getText(By.xpath("//div[@id=\"bar-notification\"]/p")));
        clickOnElement(By.xpath("//span[@class=\"close\"]"));

        // Refresh Page
        driver.navigate().refresh();
        sleep(2);

        // Take price of Nokia Lumia 1020 product
        price3 = priceConversion(By.xpath("//div[3]/div/div[2]/div[3]/div/span"));

        // Add above product to Add to Cart
        clickOnElement(By.xpath("//div[@class=\"master-column-wrapper\"]/div[2]/div/div[2]/div[3]/div/div[3]/div/div[2]/div[3]/div[2]/input"));
        Assert.assertEquals("The product has been added to your shopping cart", getText(By.xpath("//div[@id=\"bar-notification\"]/p")));

        // To calculate Total of all Above three price
        double total = price1 + price2 + price3;

        // Convert Total of all three product into String
        String totalPriceOfProduct = Double.toString(total);

        // Refresh Page
        driver.navigate().refresh();
        sleep(2);

        // Go to Add to Cart
        HomePage.goToShoppingCart();

        // Take the Total of Shopping Cart
        double cartTotal = priceConversion(By.cssSelector("span.value-summary > strong"));

        // convert cart price into String
        String totalPriceOfCart = Double.toString(cartTotal);

        // Assert Total price Of Product with Price of cart total
        Assert.assertEquals(totalPriceOfProduct,totalPriceOfCart);
    }

}


