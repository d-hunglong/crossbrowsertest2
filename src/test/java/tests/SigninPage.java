package tests;

import common.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SigninPage extends Utils {
    private static String accountDeloitte = "longdo@deloitte.com";

    @Test(priority=1)
    public void Signin() {
        input(By.cssSelector("#i0116"), accountDeloitte);
        click(By.cssSelector("#idSIButton9"));
        waitForElementPresent(By.cssSelector("#loginMessage"));
        String title = getText(By.cssSelector("#loginMessage"));
        log.info(title);
        Assert.assertEquals(title,"Sign in with your Deloitte account", "Title is wrong!");
    }

    @Test(priority=2)
    public void Username() {
        String uname = getAttribute(By.cssSelector("#userNameInput"),"value");
        log.info(uname);
        Assert.assertEquals(uname, accountDeloitte, "Username is wrong!");
    }

    @Test(priority=3)
    public  void Password(){
        input(By.cssSelector("#passwordInput"),"qwerty");
        click(By.cssSelector("#submitButton"));
        waitForElementPresent(By.cssSelector("#errorText"));
        String error = getText(By.cssSelector("#errorText"));
        log.info(error);
        Assert.assertEquals(error,"Incorrect user ID or password. Type the correct user ID and password, and try again.", "Error message is wrong!");
    }
}
