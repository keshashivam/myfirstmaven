package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by user on 4/9/2017.
 */
public class RegistrationPage extends Utils
{
    public String email;

    public void register_On_Nop_Commerce()
    {
         //Fill all the details in Registration Detail
        clickOnElement(By.id("gender-female"));
        typeText(By.name("FirstName"),"Kavita");
        typeText(By.name("LastName") ,"Shah");
        selectValue(By.name("DateOfBirthDay"),"10");
        selectValue(By.name("DateOfBirthMonth"),"4");
        selectValue(By.name("DateOfBirthYear"),"1981");

        email ="Kesah_2004"+Utils.dateStamp()+"@yahoo.com";

        typeText(By.id("Email"),email);
        typeText(By.id("Company"),"Unique Testing");

        typeText(By.id("Password"),"abc123");
        typeText(By.id("ConfirmPassword"),"abc123");

        //Click on Registeration Button
        clickOnElement(By.id("register-button"));

        Assert.assertEquals("Your registration completed",getText(By.className("result")));

        clickOnElement(By.className("ico-logout"));

        clickOnElement(By.className("ico-login"));

        typeText(By.id("Email"),email);
        typeText(By.id("Password"),"abc123");

        clickOnElement(By.cssSelector("input.button-1.login-button"));
    }
}
