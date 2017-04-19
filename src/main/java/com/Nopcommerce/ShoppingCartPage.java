package com.Nopcommerce;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by user on 4/18/2017.
 */
public class ShoppingCartPage extends Utils
{


        // Change The quantity of CellPhone
    public void changeTheQtyOfCellPhone()
    {
        changeQuantity(By.xpath("//form[@id='shopping-cart-form']/div/table/tbody/tr[1]/td[6]/input"),"2");
        changeQuantity(By.xpath("//form[@id='shopping-cart-form']/div/table/tbody/tr[3]/td[6]/input"),"3");

        // Update Shopping Cart
        clickOnElement(By.cssSelector("input.button-2.update-cart-button"));

        elementToBeVisible(By.xpath("//li[@id='topcartlink']/a/span[2]"),3);
        assertTrueContains("//li[@id='topcartlink']/a/span[2]","xpath","(6)","Quantity is not changed");
    }

    // Accept Terms And Condition and Continue for CheckOut
    public void acceptTermsAndContinueForCheckout()
    {
        // Click on Terms And Conditions check box
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        assertTrueIsSelected(By.id("termsofservice"),"Check box not checked");

        selectValue(By.id("CountryId"),"82");
        assertTrueIsSelected(By.xpath("//option[@value='82']"),"Country is not selected");

        elementToBeClickable(By.id("checkout"),2);
        clickOnElement(By.id("checkout"));


    }

    // Change the Quantity
    public void changeQuantity(By by, String x)
    {
        typeText(by, x);
    }

    // Take total price of cart for CellPhone
    public String totalOfCartPrice() {

        // Take the Total of Shopping Cart
        double cartTotal = priceConversion(By.cssSelector("span.value-summary > strong"));

        // convert cart price into String
        String totalPriceOfCart = Double.toString(cartTotal);
        return totalPriceOfCart;
    }

}
