package com.Nopcommerce;

import org.openqa.selenium.By;

/**
 * Created by user on 4/17/2017.
 */
public class VirtualGiftCard extends Utils
{
    public void emailFriend()
    {
        typeText(By.id("giftcard_43_RecipientName"),"Kavita");
        typeText(By.id("giftcard_43_RecipientEmail"),"kesah_2004@yahoo.com");
        typeText(By.id("giftcard_43_Message"),"Hi");
        clickOnElement(By.xpath("//div[@class='email-a-friend']"));
        typeText(By.id("FriendEmail"),"kesah_2004@yahoo.com");
        typeText(By.id("PersonalMessage"),"Hi It's gift for you");
        clickOnElement(By.xpath("//div[@class='buttons']"));
        driver.close();
    }

}





