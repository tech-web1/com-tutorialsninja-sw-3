package myaccount;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MyAccountsTest extends Utility {
    String baseurl = " http://tutorialsninja.com/demo/index.php? ";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException{
        //Enter Firstname
        sendKeysToElement(By.xpath("//input[@id='input-payment-firstname']"),"Nyasha");
        sendKeysToElement(By.xpath("//input[@id='input-payment-lastname']"),"Parikh");
        sendKeysToElement(By.xpath("//input[@id='input-payment-email']"),"prime123@gmail.com");
        sendKeysToElement(By.xpath("//input[@id='input-payment-telephone']"),"9898941234");
        sendKeysToElement(By.xpath("//input[@id='input-payment-password']"),"prime@123");
        sendKeysToElement(By.xpath("//input[@id='input-payment-confirm']"),"prime@123");
        Thread.sleep(1000);
    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException{
        sendKeysToElement(By.xpath("//input[@id='input-payment-firstname']"),"Nyasha");
        sendKeysToElement(By.xpath("//input[@id='input-payment-lastname']"),"Parikh");
        sendKeysToElement(By.xpath("//input[@id='input-payment-email']"),"prime123@gmail.com");
        sendKeysToElement(By.xpath("//input[@id='input-payment-telephone']"),"9898941234");
        sendKeysToElement(By.xpath("//input[@id='input-payment-password']"),"prime@123");

    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
