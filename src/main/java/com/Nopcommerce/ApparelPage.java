package com.Nopcommerce;

import org.openqa.selenium.By;

/**
 * Created by user on 4/17/2017.
 */
public class ApparelPage extends Utils
{

    // Click on Shoes Categories
    public  void shoesCategoties()
    {
        clickOnElement(By.xpath("(//a[contains(text(),'Shoes')])[3]"));
    }

    // Click on Clothing Categories
    public  void clothingCategories()
    {
        clickOnElement(By.xpath("(//a[contains(text(),'Clothing')])[3]"));
    }

    // Click on Accessories Categories
    public  void accessoriesCategoties()
    {
        clickOnElement(By.xpath("(//a[contains(text(),'Accessories')])[3]"));
    }
}
