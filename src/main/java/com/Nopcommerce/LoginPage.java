package com.Nopcommerce;

import org.openqa.selenium.By;

/**
 * Created by user on 4/9/2017.
 */
public class LoginPage extends Utils
{
    public void logInDemoNopCommerce()
    {
        clickOnElement(By.className("ico-login"));
        //Select login fromHomePage

        //fill all ligin details
        typeText(By.id("Email"),"kesah_2004@yahoo.com");
        typeText(By.id("Password"),"abc123");

        //Click on Login Button
        clickOnElement(By.cssSelector("input.button-1.login-button"));
    }
}
