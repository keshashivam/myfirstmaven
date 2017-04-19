package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by user on 4/8/2017.
 */
public class HomePage extends Utils
{
    public void clickOnRegistration()
    {

          //Click on Registeration Button

           clickOnElement(By.className("ico-register"));

         // Verify id user is navigated to registration page successsfully
         Assert.assertEquals(getText(By.xpath("//div[@class='page-title']/h1")),"Register");
    }
       public void clickOnLogInButton()

          // click on login button
       {
           clickOnElement(By.linkText("Log in"));


           // Verify is user navigated to log in page successfully
           Assert.assertEquals("Welcome, Please Sign In!",getText(By.className("page-title")));

       }

       public void nevigateToClothingPage()
       {
           clickOnElement(By.xpath("//a[contains(@href, '/apparel')]"));
           clickOnElement(By.xpath("//div[@class='master-wrapper-page']/div[3]/div[2]/div[2]/div/div[2]/div/div/div[2]"));
       }
        // click on Computers categorie
        public  void clickOnComputers()
        {
           clickOnElement(By.xpath(".//ul[@class='top-menu']//a[@href=\"/computers\"]"));
        }
         // click on Electronics categories
         public void clickOnElectonics()
    {
        clickOnElement(By.xpath("//ul[@class='top-menu']/li[2]/a"));
    }
        // click on Virtual gift card in Featured product on Homepage

        public  void clickOnVirtualGiftCard()
         {
            //click on Virtualcard
            clickOnElement(By.xpath("(//input[@value='Add to cart'])[4]"));
         }
          // click on Books categories
           public static void clickOnBooks()
         {
          clickOnElement(By.xpath("//div[@class=\"header-menu\"]/ul/li[5]/a"));
         }


        // Click on Shopping Cart Button
         public static void goToShoppingCart()
    {
        clickOnElement(By.xpath("//*[@id='topcartlink']/a/span[1]"));
    }




}
