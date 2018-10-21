package com.wtf.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.wtf.suitebase.SuiteBase;

public class BasePage {
	
	public void enterText(WebElement element,String text){		
		element.clear();
		element.sendKeys(text);
	}
	
	public void checkRadio(WebElement element,boolean selectOpt){
		if(!element.isSelected()){
			element.click();
		}
	}
	
	public void checkCheckBox(WebElement element,boolean selectOpt){
		if(!element.isSelected()){
			element.click();
		}
	}	
	
	public void selectByVisibleText(WebElement element,String text){
	    SuiteBase.getSelect(element).selectByVisibleText(text);
	}
	
	public void selectByVisibleIndex(WebElement elementId,int index){
	    SuiteBase.getSelect(elementId).selectByIndex(index);
	}
	
	public void selectByValue(WebElement element,String value){
		SuiteBase.getSelect(element).selectByValue(value);
	}
	
	
	public static <T> T initPages(Class<T> T){
		return PageFactory.initElements(SuiteBase.getDrive(), T);
	}

}
