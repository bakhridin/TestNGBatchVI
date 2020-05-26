package com.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends PageInitializer  {
	/**
	 * Method that clear and send keys
	 * @param element
	 * @param text
	 */
	
	public static void sendText(WebElement element,String text) {
		element.clear();
		element.sendKeys(text);
		
	}
	/**
	 * Method checks if radio/checkbox is enabled and click
	 * @param radioOrcheckbox
	 * @param value
	 */
	public static void clickRadioOrCheckbox(List<WebElement>radioOrcheckbox,String value) {
		
		String actualValue;
		
		for(WebElement el:radioOrcheckbox) {
			actualValue=el.getAttribute("value").trim();
			if(el.isEnabled()&& !el.isSelected()) {
				if(actualValue.equals(value)) {
					el.click();
					break;
				}
			}
		}
		
	}
	/**
	 * Method(for DropDown) if text there and then selects it by .selectByVisibleText();
	 * @param element
	 * @param textToSelect
	 */
	
	public static void selectDdValue(WebElement element,String textToSelect) {
		
		try {
			Select select=new Select(element);
			List<WebElement>options=select.getOptions();
			
			for(WebElement el:options) {
				if(el.getText().equals(textToSelect)) {
					select.selectByVisibleText(textToSelect);
					break;
				}
				
			}
			
		}catch(UnexpectedTagNameException e) {
			e.printStackTrace();
			
		}
		
	}
	/**
	 * Method(for DropDown) if index there and then selects it by .selectByIndex();
     * @param element
	 * @param index
	 */
	public static void selectDdValue(WebElement element, int index) {
		
		try {
			Select select=new Select(element);
		
			int size=select.getOptions().size();
			 if(size>index) {
				 select.selectByIndex(index);
			 }
			
			
		}catch(UnexpectedTagNameException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Method that accept alerts and catches exceptions if alert is not present
	 */
	public static void acceptAlert() {
		
	try {
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
	}catch(NoAlertPresentException e) {
		e.printStackTrace();
	}
	
	}
	/**
	 * Method that accept alerts and catches exceptions if alert is not present
	 */
	public static void dismissAlert() {
		
		try {
			Alert alert=driver.switchTo().alert();
			alert.dismiss();
			
		}catch(NoAlertPresentException e) {
			e.printStackTrace();
		}
		
		}
	
	/**
	 * Method that accept alerts and catches exceptions if alert is not present
	 * @return String alertText
	 */
	
	public static String getAlert() {
		String alertText=null;
		
		try {
			Alert alert=driver.switchTo().alert();
			alertText=alert.getText();
			
		}catch(NoAlertPresentException e) {
			e.printStackTrace();
		}
		return alertText;
		}
	
	
	/**
	 * Method that accept alerts and catches exceptions if alert is not present
	 */
     public static void sendAlertText(String text) {
		
		try {
			Alert alert=driver.switchTo().alert();
			alert.sendKeys(text);
			
		}catch(NoAlertPresentException e) {
			e.printStackTrace();
		}
		
		}
     /**
      * Method that switch to Frame by Name or Id
      * @param nameOrId
      */
    public static void switchToFrame(String nameOrId) {
    	
    	try {
    		
    		driver.switchTo().frame(nameOrId);
    		
    	}catch(NoSuchFrameException e) {
    		e.printStackTrace();
    	}
    	
    }
    /**
     * Method that switch to Frame by Index
     * @param nameOrId
     */
   public static void switchToFrame(int index) {
   	
   	try {
   		
   		driver.switchTo().frame(index);
   		
   	}catch(NoSuchFrameException e) {
   		e.printStackTrace();
   	}
   	
   }
   /**
    * Method that switch to Frame by WebElement
    * @param nameOrId
    */
  public static void switchToFrame(WebElement element) {
  	
  	try {
  		
  		driver.switchTo().frame(element);
  		
  	}catch(NoSuchFrameException e) {
  		e.printStackTrace();
  	}
  	
  }
  
  public static WebDriverWait getWaitObject() {
	  WebDriverWait wait=new WebDriverWait(driver,Constans.EXPLISIT_WAIT_TIME);
	  
	  return wait;
  }


 public static void waitForClickability(WebElement element) {
	 getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
 
}
	 
	 public static WebElement waitForVisibility(WebElement element) {
		 return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	 }
 
 
 public static void click(WebElement element) {
	 waitForClickability(element);
	 element.click();
 }
 
 public static JavascriptExecutor getJSObject() {
 JavascriptExecutor js=(JavascriptExecutor)driver;
     return js;
 }
 
 public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click();", element);
	}
 
	public static void scrollToElement(WebElement element) {
getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
	}
 
	/**
 * Method that will scroll the page down based on the passed pixel parameters
	 * 
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
	}
 
 
	/**
	 * Method that will scroll the page up based on the passed pixel parameters
	 * 
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		getJSObject().executeScript("window.scrollBy(0,-" + pixel + ")");
	}
 
public static void sleep(int second) {
	try {
		Thread.sleep(second*1000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
}
 /**
  * This method create and return object of an Actions class
  * @return 
  */
public static Actions getActionObject() {
	Actions action=new Actions(driver);
	return action;
}

/**
 * This method will hover to a specific element
 * @param element
 */

public static void moveHoverToElement(WebElement element) {
	getActionObject().moveToElement(element).perform();
	
}

public static void dragAndDrop(WebElement drag, WebElement drop) {
	getActionObject().dragAndDrop(drag, drop).perform();
	
}

public static TakesScreenshot createObjectScreenShot() {
	
	TakesScreenshot ts=(TakesScreenshot)driver;
	return ts;
	
}

public static void takeScreenshots(String filePath) {
	
	File file=createObjectScreenShot().getScreenshotAs(OutputType.FILE);
	
	try {
		FileUtils.copyFile(file, new File(filePath));
	} catch (IOException e) {
		e.printStackTrace();
	}
}





	

}
