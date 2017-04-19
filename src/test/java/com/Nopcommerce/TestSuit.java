package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by user on 4/8/2017.
 */
public class TestSuit extends BaseTest
{
    BookPage bookpage = new BookPage();
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegistrationPage registrationPage = new RegistrationPage();
    Clothing clothing= new Clothing();
    VirtualGiftCard virtualCard=new VirtualGiftCard();
    ApparelPage apparelPage=new ApparelPage();
    Cellphone cellphone=new Cellphone();
    EletronicsPage eletronicsPage=new EletronicsPage();
    ShoppingCartPage shoppingCartPage=new ShoppingCartPage();

    @Test
    public void userShouldLoginSuccessfully()
    {
        homePage.clickOnLogInButton();
        loginPage.logInDemoNopCommerce();
        Assert.assertEquals(Utils.getText(By.xpath("//div[@class='topic-block-title']/h2")),"Welcome to our store");
    }

    @Test
    public void userShouldBeLRegisterSuccessfully()
    {
        homePage.clickOnRegistration();
        registrationPage.register_On_Nop_Commerce();
        Assert.assertEquals(Utils.getText(By.className("result")),"Your Registration is Complete.");
    }

    @Test
    public void userShouldCompareProductsSuccessfully()
    {
        homePage.nevigateToClothingPage();
        clothing.selectSortByOptionLowToHigh();
        clothing.selectDisplayProductPerPage();
        clothing.selectListView();
        clothing.compareProducts();
        clothing.clearCompration();
        Assert.assertEquals(Utils.getText(By.className("no-data")),"You have no items to compare.","Comparision isnot successfull.");
    }
    @Test
    public void userShouldBeSendEmailToFriend()
    {

        homePage.clickOnVirtualGiftCard();
        virtualCard.emailFriend();
        Assert.assertEquals(Utils.getText(By.className("result")),"Your message has been sent.","");
    }
    @Test
    public void userShouldAddProductIntoAddToCartFromCellPhonePageAndCompareTotalPriceOfProductWithCartTotal()
    {
        // Open Browser
        openBroweser("http://demo.nopcommerce.com");

        // Click on Electronics Categories from Home Page
        homePage.clickOnElectonics();

        // Click on CellPhone Categories on Electronics Page
        eletronicsPage.clickOnCellPhones();

        // Add first three cell phone in to cart from cellphone pag
        Cellphone.cellPhone();

        // Verify that Total price of cellphone and Total of cart is Equal
        Utils.assertByStringVariable(cellphone.totalPriceOfProduct,shoppingCartPage.totalOfCartPrice(),"Price are not matched");

    }





}
