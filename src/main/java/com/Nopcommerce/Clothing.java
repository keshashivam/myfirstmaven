package com.Nopcommerce;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by user on 4/17/2017.
 */
public class Clothing extends Utils
{
    public void selectSortByOptionLowToHigh()
    {
        //compare product low to high
        dropDowmSelectionByAttribute(By.xpath("//select[@id='products-orderby']/option"),"text","Price: Low to High");
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='products-orderby']/option[4]")).isSelected(),"Sort by Option Price Low to High is not selected.");
    }

    public void selectDisplayProductPerPage()
    {
        //display productlist perpage
        dropDowmSelectionByAttribute(By.xpath("//select[@id='products-pagesize']/option"),"text","3");
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='products-pagesize']/option")).isSelected(),"Display 3 product is not selected.");
    }

    public void selectListView()
    {
        clickOnElement(By.xpath("//div/div/div[2]/div/div/a[2]"));
    }

    public  void compareProducts()
    {
        //compare first and last product
        clickOnElement(By.xpath("//div[2]/div/div[2]/div[3]/div[2]/input[2]"));
        clickOnElement(By.xpath("//div[3]/div/div[2]/div[3]/div[2]/input[2]"));

        //click on product comparision options
        clickOnElement(By.xpath("//div[@id='bar-notification']/p/a"));

    }

    public void clearCompration()
    {
        //clear list
        clickOnElement(By.className("clear-list"));
    }
}
