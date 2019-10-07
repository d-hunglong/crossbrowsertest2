package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils extends WebDriverLaunch{

    public static void click(By by){
        driver.findElement(by).click();
    }

    public static void clear(By by){
        driver.findElement(by).clear();
    }

    public static void input(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    public static String getText(By by){
        return driver.findElement(by).getText();
    }

    public static String getAttribute(By by, String inputAttribute){
        return driver.findElement(by).getAttribute(inputAttribute);
    }

    public static void waitForElementPresent(By by){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitForPageLoad(WebDriver driver) throws InterruptedException {
            do {
                Thread.sleep(5000);
            } while (!((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
    }

}
