package com.Nopcommerce;

import org.openqa.selenium.By;

/**
 * Created by user on 4/17/2017.
 */
public class EletronicsPage extends Utils

    {
        public  void clickOnCellPhones()
        {
            clickOnElement(By.xpath("//ul[@class=\"sublist\"]/li[2]/a"));
        }
        public  void clickOnCameraAndPhoto()
        {
            clickOnElement(By.xpath("//ul[@class='sublist']/li[1]/a"));
        }
    }


