package com.qa.pageLayer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.TestBase;

public class HomePage extends TestBase {

	public HomePage ()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//th[@id='amount']")
	private WebElement amount;
	
	public void clickOnAmount()
	{
		amount.click();
		
	}
	

	public void sortAmount()   
	{
		List<WebElement> beforeSortedAmount = driver.findElements(By.xpath("//*[@id=\"transactionsTable\"]/tbody/tr/td/span"));
		String[] beforeSortAmountList = new String[beforeSortedAmount.size()];
		
		for(int i = 0; i< beforeSortedAmount.size();i++)
		{
			beforeSortAmountList[i] = (beforeSortedAmount.get( i ).getText().trim().replace("USD", ""));
		}
		print(beforeSortAmountList);
	}


	private void print(String[] beforeSortAmountList) 
	{
		for(int i = 0;i<beforeSortAmountList.length;i++)
    	{ 
         System.out.println(beforeSortAmountList[i]); 
        } 
		
	}
	
   
}
